package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmProjectPage extends CrmBaseView{
    public CrmProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Создать проект']")
    public WebElement buttonCreateProject;

    public CrmCreateProjectPage clickCreateProject(){
        buttonCreateProject.click();
        return new CrmCreateProjectPage(driver);
    }

}
