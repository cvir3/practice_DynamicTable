package org.DynamicTable.Functions;

import org.DynamicTable.Utilities.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class funDemo extends baseClass {

    WebDriver webDriver;

    public funDemo(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    public void sorting() throws IOException, InterruptedException {
        // click on column
        webDriver.findElement(By.xpath("//tr/th[1]")).click();

        // capture all web elements into list
        List<WebElement> elementList = webDriver.findElements(By.xpath("//tr/td[1]"));

        // capture text of all web elements into new (original) list
        List<String> originalList = elementList.stream().map(WebElement::getText).collect(Collectors.toList());

        // sort the original list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // assert that the original list is equal to the sorted list
        Assert.assertEquals(originalList, sortedList);

        // Scan the name column with getText using filter

        List<String> price = elementList.stream().filter(s -> s.getText().contains("Beans")).
                map(s -> getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));
        
    }

    public void pagination() throws IOException, InterruptedException {

        List<String> price;
        //Pagination code
        do {
            List<WebElement> rows = webDriver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s -> s.getText().contains("Rice")).
                    map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                webDriver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }
        } while (price.size() < 1);

    }


    // Create a custome method.
    private static String getPriceVeggie(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }

}
