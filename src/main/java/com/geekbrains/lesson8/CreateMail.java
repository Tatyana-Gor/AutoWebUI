package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class CreateMail {

    private SelenideElement buttonSendTo = $(By.xpath("//div[.='Кому']"));

    @Step("Клик на ссылку 'Кому'")
    public CreateMail clickSendTo(){
        buttonSendTo.click();
        return this;
    }

    private SelenideElement personName = $(By.xpath("//span[.='йййй йййй']"));

    @Step("Клик на адресата")
    public CreateMail clickPersonName(){
        personName.click();
        return this;
    }

    private SelenideElement buttonAdd = $(By.xpath("//span[.='Добавить']"));

    @Step("Клик на кнопку 'Добавить'")
    public CreateMail clickButtonAdd(){
        buttonAdd.click();
        return this;
    }

    private SelenideElement inputSubject = $(By.name("Subject"));

    @Step("Заполнить поле тема")
    public CreateMail fillSubject(String subject){
        inputSubject.sendKeys(subject);
        return this;
    }

    private SelenideElement inputText = $(By.xpath("//div[@role='textbox']"));

    @Step("Заполнить тело письма")
    public CreateMail fillText(String text){
        inputText.sendKeys(text);
        return this;
    }

    private SelenideElement buttonSendMail =
            $(By.xpath("//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']"));

    @Step("Клик на кнопку 'Отправить'")
    public CreateMail clickButtonSendMail(){
        buttonSendMail.click();
        return this;
    }

    public SelenideElement succesMessage = $(By.xpath("//*[text()='Письмо отправлено']"));

}
