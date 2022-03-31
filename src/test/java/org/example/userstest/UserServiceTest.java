package org.example.userstest;

import io.restassured.response.Response;
import org.example.entities.Store;
import org.example.entities.User;
import org.example.steps.StoreServiceSteps;
import org.example.steps.UserServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class UserServiceTest {

    User newUser = createUser();
    //    Not 100% sure about this one
    @Test
    public void createUsersTest() {
        Response responseCreatedUser = UserServiceSteps.createUser(newUser);
        System.out.println(responseCreatedUser.getBody().asString());
        Assert.assertEquals(responseCreatedUser.getStatusCode(), 200, "User not created");
    }

    @Test
    public void getUserByUserName() {
        User user = UserServiceSteps.getUsersByUsername(newUser.getUsername());
        Assert.assertEquals(user.getId(), newUser.getId(), "Expected user doesn't have correct id");
        Assert.assertEquals(user.getPassword(), newUser.getPassword(), "Expected user doesn't have correct password");
        Assert.assertEquals(user.getPhone(), newUser.getPhone(), "Expected user doesn't have correct phone number");
    }

    @Test
    public void createOrderTest() {
        Store expectedOrder = createOrder();
        Store createdOrder = StoreServiceSteps.createOrder(expectedOrder);
        Assert.assertEquals(expectedOrder.getId(), createdOrder.getId(), "Order not created.");
    }

    @Test
    public void userLoginTest() {
        String username = "test";
        String password = "Krakow.2022";
        Response response = UserServiceSteps.getUserToLogin(username, password);
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    private User createUser() {
        Random random = new Random();
        return new User()
                .setId(86465 + random.nextInt(100))
                .setUsername("test45" + random.nextInt(100))
                .setEmail("testEmail" + random.nextInt(100) + "@gmail.com")
                .setFirstName("Jacky")
                .setLastName("Smithh")
                .setPassword("Krakow.2022")
                .setPhone("46729485738")
                .setUserStatus(0);
    }

    private Store createOrder() {
        Random random = new Random();
        return new Store()
                .setId(8535 + random.nextInt(100))
                .setPetId(765 + random.nextInt(100))
                .setQuantity(3 +random.nextInt(100))
                .setShipDate("2022-03-31T12:04:19.958Z")
                .setStatus("placed")
                .setComplete(true);
    }
}
