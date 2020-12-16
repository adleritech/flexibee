package com.adleritech.flexibee.core.api;

import java.lang.annotation.Annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adleritech.flexibee.core.api.FlexibeeClient.SSLConfig;
import com.adleritech.flexibee.core.api.domain.WinstromResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Component
public class FlexibeeClientFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlexibeeClientFactory.class);

    private static final String API_BASE_URL = "https://demo.flexibee.eu:5434";


    @Autowired
    private RetrofitClientFactory retrofitClientFactory;

    public FlexibeeClient createFlexibeeClient(String username, String password, String company) {
        return createFlexibeeClient(username, password, company, API_BASE_URL);
    }

    public FlexibeeClient createFlexibeeClient(String username, String password, String company, String apiBaseUrl) {
        return createFlexibeeClient(username, password, company, apiBaseUrl, null);
    }

    public FlexibeeClient createFlexibeeClient(String username, String password, String company, String apiBaseUrl, SSLConfig sslConfig) {
        LOGGER.info("action=createFlexibeeClient, company={}, apiBaseUrl={}", company, apiBaseUrl);

        Retrofit retrofit = retrofitClientFactory.prepareRetrofit(apiBaseUrl, username, password, sslConfig);
        FlexibeeClient.Api api = retrofitClientFactory.createService(FlexibeeClient.Api.class, retrofit);
        Converter<ResponseBody, WinstromResponse> errorResponseConverter = retrofit.responseBodyConverter(WinstromResponse.class, new Annotation[0]);

        return new FlexibeeClient(company, api, errorResponseConverter);
    }

}
