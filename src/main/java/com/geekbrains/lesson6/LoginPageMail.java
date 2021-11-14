package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMail extends BaseViewMail{
    public LoginPageMail(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "login")
    public WebElement inputLogin;

    @FindBy(xpath = "//button[contains(.,'Ввести пароль')]")
    public WebElement buttonLogin;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@class='second-button svelte-1tib0qz']")
    public WebElement buttonEnter;

    public LoginPageMail fillLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }
    public void submitLogin(){
        buttonLogin.click();
    }
    public LoginPageMail fillPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public void submitEnter(){
        buttonEnter.click();
    }
}
