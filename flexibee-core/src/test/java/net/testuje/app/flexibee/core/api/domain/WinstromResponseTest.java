package net.testuje.app.flexibee.core.api.domain;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.assertj.core.api.Assertions.assertThat;

public class WinstromResponseTest {

    @Test
    public void parseBadRequestResponse() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <success>false</success>\n" +
                "  <stats>\n" +
                "    <created>0</created>\n" +
                "    <updated>0</updated>\n" +
                "    <deleted>0</deleted>\n" +
                "    <skipped>0</skipped>\n" +
                "    <failed>0</failed>\n" +
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


        Serializer serializer = new Persister();
        WinstromResponse example = serializer.read(WinstromResponse.class, xml);

        assertThat(example.isSuccess()).isFalse();
        assertThat(example.getResults().size()).isEqualTo(1);

        Result firstResult = example.getResults().get(0);
        assertThat(firstResult.getErrors().size()).isEqualTo(1);
        assertThat(firstResult.getErrors().get(0).getValue()).isEqualTo("ext:user:400513200");
        assertThat(firstResult.getErrors().get(0).getMsg()).isEqualTo("Zadaný text 'ext:user:400513200' musí identifikovat objekt [200600000009]");
    }

    @Test
    public void parseSuccessResponse() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <success>true</success>\n" +
                "  <stats>\n" +
                "    <created>2</created>\n" +
                "    <updated>0</updated>\n" +
                "    <deleted>0</deleted>\n" +
                "    <skipped>0</skipped>\n" +
                "    <failed>0</failed>\n" +
                "  </stats>\n" +
                "  <results>\n" +
                "    <result>\n" +
                "      <id>2234</id>\n" +
                "      <ref>/c/demo/faktura-vydana/2234.xml</ref>\n" +
                "    </result>\n" +
                "    <result>\n" +
                "      <id>1092</id>\n" +
                "      <ref>/c/demo/adresar/1092.xml</ref>\n" +
                "    </result>\n" +
                "  </results>\n" +
                "</winstrom>\n";


        Serializer serializer = new Persister();
        WinstromResponse example = serializer.read(WinstromResponse.class, xml);

        assertThat(example.isSuccess()).isTrue();
        assertThat(example.getResults().get(0).getId()).isEqualTo("2234");
        assertThat(example.getStats().getCreated()).isEqualTo(2);
    }

}
