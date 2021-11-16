package com.geekbrains.lesson6;

import com.geekbrains.lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

@Story("Mail.ru")
public class MailObjectTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://mail.ru/");
    }

    @Test
    @DisplayName("Создание и отправка письма")
    void loginTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new LoginPageMail(driver)
                .fillLogin("testgortest")
                .submitLogin();
        new LoginPageMail(driver)
                .fillPassword("Gfhjkm25!")
                .submitEnter();
        new MailPage(driver).clickCreateMAil();
        new CreateMail(driver)
                .clickSendTo()
                .clickPersonName()
                .clickButtonAdd()
                .fillSubject("111")
                .fillText("111")
                .clickButtonSendMail();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Письмо отправлено']")).isDisplayed());
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
