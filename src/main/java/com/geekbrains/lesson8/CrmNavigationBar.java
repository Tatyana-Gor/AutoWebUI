package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CrmNavigationBar {
    ProjectSubMenu projectSubMenu;

    public CrmNavigationBar() {
        super();
        projectSubMenu = new ProjectSubMenu();
    }
    private List<SelenideElement> navBarItems = $$(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li"));

    @Step("Открытие выпадающего меню")
    public void openNavBarItem(String itemName){
        SelenideElement item = navBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        item.hover();
    }
}
