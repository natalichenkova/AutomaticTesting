package org.example.lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCart {

    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://lavkaapelsin.ru/");
        driver.findElement(By.xpath("//*[contains(text(),'Вход')]")).click();

        By formactionLocator = By.xpath("/html/body/main/div[2]/div/div/form");

        new WebDriverWait(driver, 3, 700).until(ExpectedConditions.presenceOfElementLocated(formactionLocator));

        WebElement formaction = driver.findElement(formactionLocator);
        formaction.findElement(By.name("f_email")).sendKeys("gb@secadm.ru");
        formaction.findElement(By.name("f_pass")).sendKeys("ldnq2elkgs");
        formaction.findElement(By.name("btn_login")).click();

        Thread.sleep(500);

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'nav-link  g-bg-primary g-color-white g-color-black--hover')]")))
                .click()
                .build()
                .perform();

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[contains (text () , 'Звёздные Войны. Кэнан')]")))
                .click()
                .build()
                .perform();

        driver.findElement(By.xpath("/html/body/main/div[3]/div[1]/div[2]/div[11]/div[1]")).click();

        driver.findElement(By.xpath("/html/body/main/header/div[2]/div[2]/div/a")).click();

        driver.quit();

    }

}
