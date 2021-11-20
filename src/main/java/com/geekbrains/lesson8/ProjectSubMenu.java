package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProjectSubMenu {

    private SelenideElement projectSubMenuItem = $(By.xpath("//span[.='Все проекты']"));

    @Step("Клик на подменю 'Все проекты'")
    public void projectSubMenuItemClick(){
        projectSubMenuItem.click();
    }
}
