package com.adleritech.flexibee.core.api;

import com.adleritech.flexibee.core.api.domain.WinstromRequest;
import com.adleritech.flexibee.core.api.domain.WinstromResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.io.IOException;

public class FlexibeeClient {


    private static final String API_BASE_URL = "https://demo.flexibee.eu:5434";
    private final String company;
    private final Api client;

    public FlexibeeClient(String username, String password, String company) {
        this.company = company;
        client = RetrofitClientFactory.createService(Api.class, API_BASE_URL, username, password);
    }

    public FlexibeeClient(String username, String password, String company, String apiBaseUrl) {
        this.company = company;
        client = RetrofitClientFactory.createService(Api.class, apiBaseUrl, username, password);
    }

    public WinstromResponse createInvoice(WinstromRequest winstromRequest) throws IOException {
        Response<WinstromResponse> response = client.issueInvoice(company, winstromRequest).execute();
        return response.body();
    }

    interface Api {
        @PUT("/c/{company}/faktura-vydana.xml")
        Call<WinstromResponse> issueInvoice(@Path("company") String company, @Body WinstromRequest request);
    }

}
