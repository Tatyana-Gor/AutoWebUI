package com.geekbrains.lesson6;

import com.geekbrains.lesson6.CrmLoginPage;
import com.geekbrains.lesson6.CrmMainPage;
import com.geekbrains.lesson6.CrmNavigationBar;
import com.geekbrains.lesson6.ProjectSubMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @Test
    void loginTest() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      new CrmLoginPage(driver)
              .fillLogin("Applanatest1")
              .fillPassword("Student2020!")
              .submitLogin();
      new CrmMainPage(driver).crmNavigationBar.openNavBarItem("Проекты");
      new ProjectSubMenu(driver).projectSubMenuItemClick();
      new CrmProjectPage(driver).clickCreateProject();
      new CrmCreateProjectPage(driver)
              .fillProjectName("Gorshkova11")
              .clickSpesifyCompany()
              .clickNameCompany()
              .selectBusinessUnit("Research & Development")
              .selectCurator("Applanatest Applanatest Applanatest")
              .selectRpProject("Applanatest Applanatest Applanatest")
              .selectAdministrator("Applanatest Applanatest Applanatest")
              .selectManager("Applanatest Applanatest Applanatest")
              .clickSaveAndCloseButton();

      Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Проект сохранен']")).isDisplayed());
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
