package net.testuje.app.flexibee.core.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import net.testuje.app.flexibee.core.api.domain.Error;
import net.testuje.app.flexibee.core.api.domain.WinstromRequest;
import net.testuje.app.flexibee.core.api.domain.WinstromResponse;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;


public class FlexibeeClientResponseTest {
    private final FlexibeeClient.Api api = Mockito.mock(FlexibeeClient.Api.class);
    private final Converter<ResponseBody, WinstromResponse> errorConverter = new WinstromResponseConverter();

    private final Serializer serializer = new Persister();

    private final WinstromRequest winstromRequest = mock(WinstromRequest.class);
    private final Call<WinstromResponse> call = mock(Call.class);

    private final FlexibeeClient flexibeeClient = new FlexibeeClient("winstrom", api, errorConverter);


    @Before
    public void setUp() {
        when(api.issueInvoice(anyString(),any())).thenReturn(call);
    }

    @Test
    public void successfulResponse() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <success>true</success>\n" +
                "  <stats>\n" +
                "    <created>1</created>\n" +
                "    <updated>0</updated>\n" +
                "    <deleted>0</deleted>\n" +
                "    <skipped>0</skipped>\n" +
                "    <failed>0</failed>\n" +
                "  </stats>\n" +
                "  <results>\n" +
                "    <result>\n" +
                "      <id>123</id>\n" +
                "      <ref>flexibee:faktura-vydana:123</ref>\n" +
                "    </result>\n" +
                "  </results>\n" +
                "</winstrom>";
        WinstromResponse response = serializer.read(WinstromResponse.class, xml);
        Response<WinstromResponse> callResponse = Response.success(response);
        when(call.execute()).thenReturn(callResponse);

        WinstromResponse receivedResponse = flexibeeClient.createInvoice(winstromRequest);
        assertTrue(receivedResponse.isSuccess());
        assertEquals(1, receivedResponse.getStats().getCreated());
        assertEquals(0, receivedResponse.getStats().getFailed());
        assertEquals(1, receivedResponse.getResults().size());
        assertEquals("123", receivedResponse.getResults().get(0).getId());
        assertEquals("flexibee:faktura-vydana:123", receivedResponse.getResults().get(0).getRef());
    }

    @Test
    public void unsuccessfulResponse() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <success>false</success>\n" +
                "  <stats>\n" +
                "    <created>0</created>\n" +
                "    <updated>0</updated>\n" +
                "    <deleted>0</deleted>\n" +
                "    <skipped>0</skipped>\n" +
                "    <failed>1</failed>\n" +
                "  </stats>\n" +
                "  <results>\n" +
                "    <result>\n" +
                "      <errors>\n" +
                "        <error " +
                "          path=\"faktura-vydana[temporary-id=null].firma\" " +
                "          code=\"PROP\" " +
                "          for=\"firma\" " +
                "          value=\"ext:user:400513200\">Zadaný text 'ext:user:400513200' musí identifikovat objekt [200600000009]</error>\n" +
                "      </errors>\n" +
                "    </result>\n" +
                "  </results>\n" +
                "</winstrom>";
        Response<WinstromResponse> callResponse = Response.error(400, ResponseBody.create(MediaType.parse("application/xml"), xml));
        when(call.execute()).thenReturn(callResponse);

        try {
            flexibeeClient.createInvoice(winstromRequest);
            fail();
        } catch (FlexibeeClient.FlexibeeException fe) {
            WinstromResponse errorResponse = fe.getErrorResponse();
            assertNotNull(errorResponse);

            assertFalse(errorResponse.isSuccess());
            assertEquals(1, errorResponse.getStats().getFailed());
            assertEquals(0, errorResponse.getStats().getCreated());
            assertEquals(1, errorResponse.getResults().size());
            assertEquals(1, errorResponse.getResults().get(0).getErrors().size());

            Error error = errorResponse.getResults().get(0).getErrors().get(0);
            assertEquals("PROP", error.getCode());
            assertEquals("faktura-vydana[temporary-id=null].firma", error.getPath());
            assertEquals("Zadaný text 'ext:user:400513200' musí identifikovat objekt [200600000009]", error.getMsg());

            assertEquals(xml, fe.getRawErrorResponse());
        }
    }

    @Test
    public void invalidResponse() throws Exception {
        /* Mandatory attributes missing */
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <results>\n" +
                "    <result>\n" +
                "      <errors>\n" +
                "        <error " +
                "          path=\"faktura-vydana[temporary-id=null].firma\" " +
                "          code=\"PROP\" " +
                "          for=\"firma\" " +
                "          value=\"ext:user:400513200\">Zadaný text 'ext:user:400513200' musí identifikovat objekt [200600000009]</error>\n" +
                "      </errors>\n" +
                "    </result>\n" +
                "  </results>\n" +
                "</winstrom>";
        Response<WinstromResponse> callResponse = Response.error(400, ResponseBody.create(MediaType.parse("application/xml"), xml));
        when(call.execute()).thenReturn(callResponse);

        try {
            flexibeeClient.createInvoice(winstromRequest);
            fail();
        } catch (FlexibeeClient.FlexibeeException fe) {
            WinstromResponse errorResponse = fe.getErrorResponse();
            assertNull(errorResponse);
            assertEquals(xml, fe.getRawErrorResponse());
        }
    }

    @Test
    public void nonXmlResponse() throws Exception {
        String xml = "Such invalid response that its not even xml";
        Response<WinstromResponse> callResponse = Response.error(400, ResponseBody.create(MediaType.parse("application/xml"), xml));
        when(call.execute()).thenReturn(callResponse);

        try {
            flexibeeClient.createInvoice(winstromRequest);
            fail();
        } catch (FlexibeeClient.FlexibeeException fe) {
            WinstromResponse errorResponse = fe.getErrorResponse();
            assertNull(errorResponse);
            assertEquals(xml, fe.getRawErrorResponse());
        }
    }

    @Test
    public void notFoundResponse() throws Exception {
        Response<WinstromResponse> callResponse = Response.error(404, ResponseBody.create(MediaType.parse("plain/text"), "NotFound"));
        when(call.execute()).thenReturn(callResponse);

        try {
            flexibeeClient.createInvoice(winstromRequest);
            fail();
        } catch (FlexibeeClient.NotFound fe) {
            WinstromResponse errorResponse = fe.getErrorResponse();
            assertNull(errorResponse);
        }
    }
}
