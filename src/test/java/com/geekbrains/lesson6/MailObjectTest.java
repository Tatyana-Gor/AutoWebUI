package com.geekbrains.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MailObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://mail.ru/");
    }

    @Test
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
        driver.quit();
    }
}
