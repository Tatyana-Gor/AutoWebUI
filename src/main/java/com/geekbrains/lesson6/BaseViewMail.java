package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseViewMail {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseViewMail(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
