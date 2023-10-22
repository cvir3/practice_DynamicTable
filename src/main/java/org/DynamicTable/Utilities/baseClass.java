package org.DynamicTable.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;


public class baseClass {
    public static WebDriver webDriver;

    @BeforeClass
    public void setup() throws IOException {
//        propertiesRead propertiesRead = new propertiesRead();
//        String url = propertiesRead.readProperties("URL");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        System.out.println("Page title is " + webDriver.getTitle());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void teraDown() {
        webDriver.quit();
    }

}
