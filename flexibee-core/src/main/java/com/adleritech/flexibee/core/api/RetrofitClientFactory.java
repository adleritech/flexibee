package com.adleritech.flexibee.core.api;

import com.adleritech.flexibee.core.api.transformers.Factory;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class RetrofitClientFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.adleritech.flexibee.core.api.http");

    static <S> S createService(Class<S> serviceClass, String apiBaseUrl, String username, String password) {
        Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Factory.persister()));
        String authToken = Credentials.basic(username, password);
        builder.client(createOkHttpClient(authToken));

        return builder.build().create(serviceClass);
    }

    private static OkHttpClient createOkHttpClient(String authToken) {
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER::debug);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);
        httpClient.followRedirects(true);
        httpClient.followSslRedirects(true);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        return httpClient.build();
    }

    static class AuthenticationInterceptor implements Interceptor {
        private String authToken;

        AuthenticationInterceptor(String token) {
            this.authToken = token;
        }

        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder().header("Authorization", authToken);
            Request request = builder.build();
            return chain.proceed(request);
        }
    }

}
