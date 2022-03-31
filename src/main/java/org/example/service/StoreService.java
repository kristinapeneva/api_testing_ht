package org.example.service;

import io.restassured.response.Response;
import org.example.service.uritemplate.UriTemplate;

public class StoreService extends CommonService{
    private static StoreService instance;

    public static StoreService getInstance() {
        if (instance == null) {
            instance = new StoreService();
        }
        return instance;
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }
}
