package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;

public class CrmMainPage extends CrmBaseView{
   public CrmNavigationBar crmNavigationBar;

    public CrmMainPage(WebDriver driver) {
        super(driver);
        crmNavigationBar = new CrmNavigationBar(driver);
    }
}
