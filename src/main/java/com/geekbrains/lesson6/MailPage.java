package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage extends BaseViewMail{
    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a/span[.='Написать письмо']")
    public WebElement buttonCreateMail;

    public CreateMail clickCreateMAil(){
        buttonCreateMail.click();
        return new CreateMail(driver);
    }
}
