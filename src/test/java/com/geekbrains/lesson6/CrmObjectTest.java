package com.geekbrains.lesson6;

import com.geekbrains.lesson6.CrmLoginPage;
import com.geekbrains.lesson6.CrmMainPage;
import com.geekbrains.lesson6.CrmNavigationBar;
import com.geekbrains.lesson6.ProjectSubMenu;
import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

@Story("CRM Geekbrains")
public class CrmObjectTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/user/login");
    }

    @Test
    @DisplayName("Создание проекта")
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
              .fillProjectName("Gorshkova14")
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
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = browserLogs.iterator();
        while (iterator.hasNext()) {
            Allure.addAttachment("Лог в консоли браузера", iterator.next().getMessage());
        }
        for (LogEntry log: browserLogs) {
            System.out.println(log.getMessage());
        }

        driver.quit();
    }
}
