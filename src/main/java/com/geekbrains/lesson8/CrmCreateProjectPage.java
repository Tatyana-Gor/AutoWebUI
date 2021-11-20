package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CrmCreateProjectPage{

    private SelenideElement inputProjectName = $(By.xpath("//input[contains(@id, 'crm_project_name')]"));

    @Step("Заполнить название организации")
    public CrmCreateProjectPage fillProjectName(String projectName){
        inputProjectName.sendKeys(projectName);
        return this;
    }

    private SelenideElement spesifyCompany = $(By.xpath("//span[.='Укажите организацию']"));

    @Step("Клик на список организаций")
    public CrmCreateProjectPage clickSpesifyCompany(){
        spesifyCompany.click();
        return this;
    }

    private SelenideElement nameCompany = $(By.xpath("//div[text()='1234']"));

    @Step("Клик на название организации")
    public CrmCreateProjectPage clickNameCompany(){
        nameCompany.click();
        return this;
    }

    private SelenideElement selectBusinessUnit = $(By.name("crm_project[businessUnit]"));

    @Step("Выбрать бизнес юнит")
    public CrmCreateProjectPage selectBusinessUnit(String option){
        selectBusinessUnit.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement selectCurator = $(By.name("crm_project[curator]"));

    @Step("Выбрать куратора")
    public CrmCreateProjectPage selectCurator(String option){
        selectCurator.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement selectRpProject = $(By.name("crm_project[rp]"));

    @Step("Выбрать руководителя проекта")
    public CrmCreateProjectPage selectRpProject(String option){
        selectRpProject.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement selectAdministrator = $(By.name("crm_project[administrator]"));

    @Step("Выбрать администратора")
    public CrmCreateProjectPage selectAdministrator(String option){
        selectAdministrator.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement selectManager = $(By.name("crm_project[manager]"));

    @Step("Выбрать менеджера")
    public CrmCreateProjectPage selectManager(String option){
        selectManager.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(.,'Сохранить и закрыть')]"));

    @Step("Клик на кнопку сохранения")
    public CrmCreateProjectPage clickSaveAndCloseButton(){
        saveAndCloseButton.click();
        return this;
    }
    public SelenideElement succesMessage = $(By.xpath("//*[text()='Проект сохранен']"));
}
