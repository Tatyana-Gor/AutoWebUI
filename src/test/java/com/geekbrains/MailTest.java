package com.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.concurrent.TimeUnit;

public class MailTest {
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
    @DisplayName("Создание и отправка письма")
    void mail(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a/span[.='Написать письмо']")).click();
        driver.findElement(By.xpath("//div[.='Кому']")).click();
        WebElement checkSample = driver.findElement(By.xpath("//span[.='йййй йййй']"));
        assertThat(checkSample.getText(), containsString("йййй йййй"));
        driver.findElement(By.xpath("//span[.='йййй йййй']")).click();
        driver.findElement(By.xpath("//span[.='Добавить']")).click();
        driver.findElement(By.name("Subject")).sendKeys("111");
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test");
        driver.findElement(By.xpath
                ("//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']")).click();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
    static void login(WebDriver driver) {
        driver.get("https://mail.ru/");
        driver.findElement(By.name("login")).sendKeys("testgortest");
        driver.findElement(By.xpath("//button[contains(.,'Ввести пароль')]")).click();
        driver.findElement(By.name("password")).sendKeys("Gfhjkm25!");
        driver.findElement(By.xpath("//button[@class='second-button svelte-1tib0qz']")).click();
    }
}
