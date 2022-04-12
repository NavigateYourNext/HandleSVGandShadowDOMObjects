package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleSVGElements {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1GCEJ_enZA997ZA997&oq=covid+cases+in+india&aqs=chrome..69i57.3091j0j3&sourceid=chrome&ie=UTF-8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> graphList = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[1]//*[local-name()='rect']"));
        Actions action = new Actions(driver);
        for(WebElement element:graphList){
            action.moveToElement(element).perform();
            String text = driver.findElement(By.xpath("//div[@class='GxwVnb']")).getText();
            System.out.println(text);
        }



    }


}
