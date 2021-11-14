package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmLoginPage extends CrmBaseView {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    public CrmLoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public CrmLoginPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public void submitLogin() {
        buttonLogin.click();
    }

    public CrmLoginPage(WebDriver driver) {
        super(driver);
    }
}

