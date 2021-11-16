package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmProjectPage extends CrmBaseView{
    public CrmProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Создать проект']")
    public WebElement buttonCreateProject;

    @Step("Клик на кнопку 'Создать проект'")
    public CrmCreateProjectPage clickCreateProject(){
        buttonCreateProject.click();
        return new CrmCreateProjectPage(driver);
    }

}
