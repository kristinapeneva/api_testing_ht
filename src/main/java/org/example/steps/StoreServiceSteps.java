package org.example.steps;

import org.example.entities.Store;
import org.example.service.StoreService;

import static org.example.service.uritemplate.StoreServiceUri.STORE_ORDER;

public class StoreServiceSteps {
    private static final StoreService STORE_SERVICE = StoreService.getInstance();
    public static Store createOrder(Store storeOrder) {
        return STORE_SERVICE.postRequest(STORE_ORDER, storeOrder).as(Store.class);
    }
}
