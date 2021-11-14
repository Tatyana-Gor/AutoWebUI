package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSubMenu extends CrmBaseView{
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Все проекты']")
    public WebElement projectSubMenuItem;

    public void projectSubMenuItemClick(){
        projectSubMenuItem.click();
    }
}
