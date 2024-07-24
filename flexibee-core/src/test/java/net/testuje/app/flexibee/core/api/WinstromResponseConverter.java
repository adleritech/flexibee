package net.testuje.app.flexibee.core.api;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import net.testuje.app.flexibee.core.api.domain.WinstromResponse;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import retrofit2.Converter;

public class WinstromResponseConverter implements Converter<ResponseBody, WinstromResponse> {

    private final Serializer serializer = new Persister();

    @SneakyThrows
    @Override
    public WinstromResponse convert(ResponseBody responseBody) {
        String raw = responseBody.string();
        return serializer.read(WinstromResponse.class, raw);
    }
}
