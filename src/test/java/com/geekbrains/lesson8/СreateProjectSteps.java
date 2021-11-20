package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class СreateProjectSteps {
    @Given("^I am authorized$")
    public void iAmAutorized(){
        Selenide.open("https://crm.geekbrains.space/");
        new LoginPageCRM().fillLogin("Applanatest1").fillPassword("Student2020!").submitLogin();
    }

    @Given("^Я перехожу с помощью интерфейса на страницу создания проекта$")
    public void goToCreateProjectPageUsingInterface() {
        new MainPaigeCRM().crmNavigationBar.openNavBarItem("Все проекты");
        new ProjectSubMenu().projectSubMenuItemClick();
        new CrmProjectPage().clickCreateProject();
    }

    @When("^Я заполняю название проекта$")
    public void iFillProjectName() {
        new CrmCreateProjectPage().fillProjectName("Gorshkova15");
    }

    @And("^Кликаю на выбор организации$")
    public void iClickSpesifyCompany() {
        new CrmCreateProjectPage().clickSpesifyCompany();
    }

    @And("^Выбираю организацию$")
    public void iClickNameCompany() {
        new CrmCreateProjectPage().clickNameCompany();
    }

    @And("^Выбираю бизнес юнита$")
    public void iSelectBusinessUnit() {
        new CrmCreateProjectPage().selectBusinessUnit("Research & Development");
    }

    @And("^Выбираю куратора$")
    public void iSelectCurator() {
        new CrmCreateProjectPage().selectCurator("Applanatest Applanatest Applanatest");
    }

    @And("^Выбираю руководителя проекта$")
    public void iSelectRpProject() {
        new CrmCreateProjectPage().selectRpProject("Applanatest Applanatest Applanatest");
    }

    @And("^Выбираю администратора$")
    public void iSelectAdministrator() {
        new CrmCreateProjectPage().selectAdministrator("Applanatest Applanatest Applanatest");
    }

    @And("^Выбираю менеджера$")
    public void iSelectManager() {
        new CrmCreateProjectPage().selectManager("Applanatest Applanatest Applanatest");
    }

    @And("^Кликаю на кнопку сохранения$")
    public void iClickSaveAndCloseButton() {
        new CrmCreateProjectPage().clickSaveAndCloseButton();
    }

    @Then("^Вижу сообщение после успешного сохранения проекта$")
    public void iSeeSuccessMessage() {
        new CrmCreateProjectPage().succesMessage.shouldBe(Condition.visible, Duration.ofMillis(10_000));
    }
}
