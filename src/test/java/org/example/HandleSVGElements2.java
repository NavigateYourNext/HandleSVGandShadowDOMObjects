package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleSVGElements2 {

    public static void main(String[] args) throws ParseException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/search?q=covid+cases+in+india&rlz=1C1GCEJ_enZA997ZA997&oq=covid+cases+in+india&aqs=chrome..69i57.3091j0j3&sourceid=chrome&ie=UTF-8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement graphList = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[2]"));
        int getTopLeftY = ((graphList.getSize().getHeight())/2) - ((graphList.getSize().getHeight()));
        int getTopLeftX = ((graphList.getSize().getWidth())/2) - ((graphList.getSize().getWidth()));

        Actions action = new Actions(driver);
        String date = "20-03-2020";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = sdf.parse(date);
        Date d2 = new Date();
        long difference = TimeUnit.MILLISECONDS.toDays(d2.getTime() - d1.getTime());

        for(int i=0; i<difference; i++) {
            action.moveToElement(graphList, getTopLeftX+i, getTopLeftY+i).perform();
            String text = driver.findElement(By.xpath("//table[@class='swWWne']/tbody")).getText();
            System.out.println(text);
        }


    }

}
