package org.example.steps;

import io.restassured.response.Response;
import org.example.entities.User;
import org.example.service.UserService;

import static org.example.service.uritemplate.UserServiceUri.*;

public class UserServiceSteps {
    private static final UserService USER_SERVICE = UserService.getInstance();


    public static User getUsersByUsername(String username) {
        return USER_SERVICE.getRequest(USER_USERNAME, username).as(User.class);
    }

    public static Response getUserToLogin(String username, String password) {
        return USER_SERVICE.getRequest(USER_LOGIN, username, password);
    }

    public static Response createUser(User user) {
        return USER_SERVICE.postRequest(USERS, user);
    }

}
