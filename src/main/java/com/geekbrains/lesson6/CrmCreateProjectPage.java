package com.geekbrains.lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CrmCreateProjectPage extends CrmBaseView{
    public CrmCreateProjectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[contains(@id, 'crm_project_name')]")
    public WebElement inputProjectName;

    @Step("Заполнить название организации")
    public CrmCreateProjectPage fillProjectName(String projectName){
        inputProjectName.sendKeys(projectName);
        return this;
    }

    @FindBy(xpath = "//span[.='Укажите организацию']")
    public WebElement spesifyCompany;

    @Step("Клик на список организаций")
    public CrmCreateProjectPage clickSpesifyCompany(){
        spesifyCompany.click();
        return this;
    }
    @FindBy(xpath = "//div[text()='1234']")
    public WebElement nameCompany;

    @Step("Клик на название организации")
    public CrmCreateProjectPage clickNameCompany(){
        nameCompany.click();
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement selectBusinessUnit;

    @Step("Выбрать бизнес юнит")
    public CrmCreateProjectPage selectBusinessUnit(String option){
        new Select(selectBusinessUnit).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement selectCurator;

    @Step("Выбрать куратора")
    public CrmCreateProjectPage selectCurator(String option){
        new Select(selectCurator).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement selectRpProject;

    @Step("Выбрать руководителя проекта")
    public CrmCreateProjectPage selectRpProject(String option){
        new Select(selectRpProject).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectAdministrator;

    @Step("Выбрать администратора")
    public CrmCreateProjectPage selectAdministrator(String option){
        new Select(selectAdministrator).selectByVisibleText(option);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement selectManager;

    @Step("Выбрать менеджера")
    public CrmCreateProjectPage selectManager(String option){
        new Select(selectManager).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    public WebElement saveAndCloseButton;

    @Step("Клик на кнопку сохранения")
    public CrmCreateProjectPage clickSaveAndCloseButton(){
        saveAndCloseButton.click();
        return this;
    }
}
