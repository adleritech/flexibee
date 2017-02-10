package com.adleritech.flexibee.api;

import com.adleritech.flexibee.api.domain.WinstromResponse;

public class Client {

    interface Api {
        WinstromResponse issueInvoice();
    }

    public static void ClientFactory(String username, String password) {

    }

}
