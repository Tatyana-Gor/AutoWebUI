package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMail extends BaseViewMail {
    public CreateMail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[.='Кому']")
    public WebElement buttonSendTo;

    @Step("Клик на ссылку 'Кому'")
    public CreateMail clickSendTo(){
        buttonSendTo.click();
        return this;
    }

    @FindBy(xpath = "//span[.='йййй йййй']")
    public WebElement personName;

    @Step("Клик на адресата")
    public CreateMail clickPersonName(){
        personName.click();
        return this;
    }

    @FindBy(xpath = "//span[.='Добавить']")
    public WebElement buttonAdd;

    @Step("Клик на кнопку 'Добавить'")
    public CreateMail clickButtonAdd(){
        buttonAdd.click();
        return this;
    }

    @FindBy(name = "Subject")
    public WebElement inputSubject;

    @Step("Заполнить поле тема")
    public CreateMail fillSubject(String subject){
        inputSubject.sendKeys(subject);
        return this;
    }

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement inputText;

    @Step("Заполнить тело письма")
    public CreateMail fillText(String text){
        inputText.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']")
    public WebElement buttonSendMail;

    @Step("Клик на кнопку 'Отправить'")
    public CreateMail clickButtonSendMail(){
        buttonSendMail.click();
        return this;
    }

}
