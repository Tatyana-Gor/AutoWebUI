package com.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.geekbrains.lesson5.Helpers.clickWithJS;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.containsString;



public class CrmTest {
    WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        login(driver);
    }

    @Test
    @DisplayName("Создание проекта")
    void project() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name')]")).sendKeys("Gorshkova9");
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
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("11111");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        WebElement saveProject = driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        assertThat(saveProject.getText(), containsString("Проект сохранен"));
    }

    @Test
    @DisplayName("Создание контактного лица")
    void person(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/contact/create");
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Gorshkova");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Tatyana");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[text()='1234']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        WebElement savePerson = driver.findElement(By.xpath("//*[text()='Контактное лицо сохраненон']"));
        assertThat(savePerson.getText(), containsString("Контактное лицо сохранено"));
    }


    @AfterEach
    void tearDown(){
        driver.quit();
    }

    static void login(WebDriver driver){
        driver.get("https://crm.geekbrains.space");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
