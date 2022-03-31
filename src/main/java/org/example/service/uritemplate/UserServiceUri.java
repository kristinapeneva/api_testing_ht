package org.example.service.uritemplate;

public class UserServiceUri {
    public static final UriTemplate USERS = new UriTemplate("user");
    public static final UriTemplate USER_USERNAME = new UriTemplate("user/%s");
    public static final UriTemplate USER_LOGIN = new UriTemplate("user/login");
}
