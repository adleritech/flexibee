package com.adleritech.flexibee.api.domain;

import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.assertj.core.api.Assertions.assertThat;

public class WinstromResponseTest {

    @Test
    public void parseSuccessFalse() throws Exception {
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
                "        <error>javax.xml.stream.XMLStreamException: ParseError at [row,col]:[1,1]\n" +
                "Message: Premature end of file.\n" +
                "ParseError at [row,col]:[1,1]\n" +
                "Message: Premature end of file.</error>\n" +
                "      </errors>\n" +
                "    </result>\n" +
                "  </results>\n" +
                "</winstrom>";


        Serializer serializer = new Persister();
        WinstromResponse example = serializer.read(WinstromResponse.class, xml);

        assertThat(example.isSuccess()).isFalse();
    }

    @Test
    public void parseSuccessResponse() throws Exception {
        String xml = "<winstrom version=\"1.0\">\n" +
                "  <success>true</success>\n" +
                "  <result>\n" +
                "    <id>105</id>\n" +
                "  </result>\n" +
                "</winstrom>";


        Serializer serializer = new Persister();
        WinstromResponse example = serializer.read(WinstromResponse.class, xml);

        assertThat(example.isSuccess()).isTrue();
        assertThat(example.getResult().getId()).isEqualTo("105");
    }

}
