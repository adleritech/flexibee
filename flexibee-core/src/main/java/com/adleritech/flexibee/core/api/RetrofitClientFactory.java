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

class RetrofitClientFactory {

    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static final Logger LOGGER = LoggerFactory.getLogger("com.adleritech.flexibee.core.api.http");

    private static Retrofit.Builder builder;

    static <S> S createService(Class<S> serviceClass, String apiBaseUrl, String username, String password) {
        builder = new Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Factory.persister()));
        String authToken = Credentials.basic(username, password);
        return createService(serviceClass, authToken);
    }

    private static <S> S createService(Class<S> serviceClass, final String authToken) {
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);
        Retrofit retrofit = null;
        if (!httpClient.interceptors().contains(interceptor)) {
            httpClient.addInterceptor(interceptor);
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER::debug);
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(loggingInterceptor);
            httpClient.followRedirects(true);
            httpClient.followSslRedirects(true);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        assert retrofit != null;
        return retrofit.create(serviceClass);
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
