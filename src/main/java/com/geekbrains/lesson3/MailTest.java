package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        login(driver);
        mail(driver);

        Thread.sleep(1000);

        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.findElement(By.name("login")).sendKeys("testgortest");
        driver.findElement(By.xpath("//button[contains(.,'Ввести пароль')]")).click();
        driver.findElement(By.name("password")).sendKeys("Gfhjkm25!");
        driver.findElement(By.xpath("//button[@class='second-button svelte-1tib0qz']")).click();
    }

    static void mail(WebDriver driver)  {
        driver.findElement(By.xpath("//a/span[.='Написать письмо']")).click();
        driver.findElement(By.xpath("//div[.='Кому']")).click();
        driver.findElement(By.xpath("//span[.='йййй йййй']")).click();
        driver.findElement(By.xpath("//span[.='Добавить']")).click();
        driver.findElement(By.name("Subject")).sendKeys("111");
        driver.findElement(By.xpath("//span[@class='button2 button2_base button2_primary button2_hover-support js-shortcut']")).click();
        driver.findElement(By.xpath("//span[.='Отправить']")).click();
    }
}
