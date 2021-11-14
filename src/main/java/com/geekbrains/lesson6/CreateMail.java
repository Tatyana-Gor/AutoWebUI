package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateMail extends BaseViewMail {
    public CreateMail(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[.='Кому']")
    public WebElement buttonSendTo;
    public CreateMail clickSendTo(){
        buttonSendTo.click();
        return this;
    }

    @FindBy(xpath = "//span[.='йййй йййй']")
    public WebElement personName;
    public CreateMail clickPersonName(){
        personName.click();
        return this;
    }

    @FindBy(xpath = "//span[.='Добавить']")
    public WebElement buttonAdd;
    public CreateMail clickButtonAdd(){
        buttonAdd.click();
        return this;
    }

    @FindBy(name = "Subject")
    public WebElement inputSubject;
    public CreateMail fillSubject(String subject){
        inputSubject.sendKeys(subject);
        return this;
    }

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement inputText;
    public CreateMail fillText(String text){
        inputText.sendKeys(text);
        return this;
    }

    @FindBy(xpath = "//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']")
    public WebElement buttonSendMail;
    public CreateMail clickButtonSendMail(){
        buttonSendMail.click();
        return this;
    }

}
