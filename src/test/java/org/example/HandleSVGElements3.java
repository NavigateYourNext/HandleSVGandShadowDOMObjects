package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class HandleSVGElements3 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://emicalculator.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       List<WebElement> graphList =  driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='g' and @class='highcharts-series-group']//*[local-name()='rect']"));
       Actions action = new Actions(driver);
       for(WebElement element:graphList){
           action.moveToElement(element).perform();
           String text = driver.findElement(By.xpath("//*[local-name()='svg']//*[local-name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[local-name()='text']")).getText();
           System.out.println(text);
           Thread.sleep(200);
       }
    }
}
