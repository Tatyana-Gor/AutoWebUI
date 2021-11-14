package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmBaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public CrmBaseView(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
