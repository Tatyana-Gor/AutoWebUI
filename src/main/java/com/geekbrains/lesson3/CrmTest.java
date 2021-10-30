package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CrmTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        project(driver);
        person(driver);

        Thread.sleep(1000);

        driver.quit();
    }

    static void login(WebDriver driver){
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    static void project(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Проекты']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("Gorshkova4");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[text()='1234']")).click();
        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Applanatest Applanatest Applanatest");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
    }

    static void person(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a/span[.='Контрагенты']"))).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Gorshkova");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Tatyana");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[text()='1234']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
    }
}
