package com.geekbrains.lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class CreateMailSteps {
    @Given("I am autoriz")
    public void iAmAutoriz() {
        Selenide.open("https://mail.ru/");
        new LoginPageMail().fillLogin("testgortest").submitLogin();
        new LoginPageMail().fillPassword("Gfhjkm25!").submitEnter();
    }

    @Given("I go to create mail interface")
    public void iGoToCreateMailInterface() {
        new MailPage().clickCreateMail();
    }

    @When("I click send to")
    public void iClickSendTo() {
        new CreateMail().clickSendTo();
    }

    @And("I click person name")
    public void iClickPersonName() {
        new CreateMail().clickPersonName();
    }

    @And("I click add")
    public void iClickAdd() {
        new CreateMail().clickButtonAdd();
    }

    @And("I fill subject")
    public void iFillSubject() {
        new CreateMail().fillSubject("111");
    }

    @And("I fill text")
    public void iFillText() {
        new CreateMail().fillText("111");
    }

    @And("I click send mail")
    public void iClickSendMail() {
        new CreateMail().clickButtonSendMail();
    }

    @Then("I see success message")
    public void iSeeSuccessMessage() {
        new CreateMail().succesMessage.shouldBe(Condition.visible, Duration.ofMillis(10_000));
    }
}
