package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CrmNavigationBar extends CrmBaseView{
    ProjectSubMenu projectSubMenu;

    public CrmNavigationBar(WebDriver driver) {
        super(driver);
        projectSubMenu = new ProjectSubMenu(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
    public List<WebElement> navBarItems;

    @Step("Открытие выпадающего меню")
    public void openNavBarItem(String itemName){
        Actions actions = new Actions(driver);
        WebElement item = navBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        actions.moveToElement(item).build().perform();
    }
}
