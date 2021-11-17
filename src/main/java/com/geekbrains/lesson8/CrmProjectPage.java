package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CrmProjectPage {

    private SelenideElement buttonCreateProject = $(By.xpath("//a[.='Создать проект']"));

    @Step("Клик на кнопку 'Создать проект'")
    public CrmCreateProjectPage clickCreateProject(){
        buttonCreateProject.click();
        return page(com.geekbrains.lesson8.CrmCreateProjectPage.class);
    }

}
