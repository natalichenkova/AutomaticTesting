package org.example.lesson_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginAndLogout {

    public static void main( String[] args ) throws InterruptedException  {
        System.setProperty( "webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver ();
        driver.get ("https://lavkaapelsin.ru/");
        driver.findElement(By.xpath("//*[contains(text(),'Вход')]")).click();

        By formactionLocator = By.xpath("/html/body/main/div[2]/div/div/form");

        new WebDriverWait(driver,3,700).until(ExpectedConditions.presenceOfElementLocated(formactionLocator));

        WebElement formaction = driver.findElement(formactionLocator);
        formaction.findElement(By.name("f_email")).sendKeys("gb@secadm.ru");
        formaction.findElement(By.name("f_pass")).sendKeys("ldnq2elkgs");
        formaction.findElement(By.name("btn_login")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[contains(@class,'media-body mr-2')]")).click();

        driver.findElement(By.xpath ("//a[text()='Выход']")).click();

        driver.quit();


    }

}
