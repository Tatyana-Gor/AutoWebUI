package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MailPage{

    private SelenideElement buttonCreateMail = $(By.xpath("//a/span[.='Написать письмо']"));

    @Step("Клик на кнопку 'Написать письмо'")
    public CreateMail clickCreateMail(){
        buttonCreateMail.click();
        return page(com.geekbrains.lesson8.CreateMail.class);
    }
}
