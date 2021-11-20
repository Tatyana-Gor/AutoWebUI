package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageMail  {

    private SelenideElement inputLogin = $(By.name("login"));

    private SelenideElement buttonLogin = $(By.xpath("//button[contains(.,'Ввести пароль')]"));

    private SelenideElement inputPassword = $(By.name("password"));

    private SelenideElement buttonEnter = $(By.xpath("//button[@class='second-button svelte-1tib0qz']"));

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
