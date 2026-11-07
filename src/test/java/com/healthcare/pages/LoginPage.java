
package com.healthcare.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By submit = By.id("login-button");
    private final By error = By.id("login-error");

    public void open(String baseUrl) {
        driver().get(baseUrl);
    }

    public boolean isLoginPageDisplayed() {
        return displayed(email)
                && displayed(password)
                && displayed(submit);
    }

    public void login(String user, String pass) {
        type(email, user);
        type(password, pass);
        click(submit);
    }

    public String errorMessage() {
        return text(error);
    }
}
