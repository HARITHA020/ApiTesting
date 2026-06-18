package com.test;

import org.testng.annotations.Test;

public class LoginApi extends BaseTest {

    @Test
    public void loginTest() {
        System.out.println("Token already generated in BaseTest: " + token);
    }
}