package com.geekbrains.lesson6;

import io.qameta.allure.Step;
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

    @Step("Заполнить поле логин")
    public LoginPageMail fillLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Клик на кнопку 'Ввести пароль'")
    public void submitLogin(){
        buttonLogin.click();
    }

    @Step("Заполнить поле пароль")
    public LoginPageMail fillPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Клик на кнопку входа")
    public void submitEnter(){
        buttonEnter.click();
    }
}
