package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSubMenu extends CrmBaseView{
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement projectSubMenuItem;

    @Step("Клик на подменю 'Все проекты'")
    public void projectSubMenuItemClick(){
        projectSubMenuItem.click();
    }
}
