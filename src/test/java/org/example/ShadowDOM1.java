package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShadowDOM1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.switchTo().frame("pact"); //switch to frame, as the elements are under the frame
        String tea = "return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')"; //document.querySelector use to get the webelement present in shadow root
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement teaWebElement = (WebElement)jse.executeScript(tea);
        jse.executeScript("arguments[0].setAttribute('value','Green Tea')",teaWebElement);

    }
}
