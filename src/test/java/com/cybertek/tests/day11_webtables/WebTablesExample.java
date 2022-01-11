package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllHeaders(){
            //how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize(){
        // how many columns we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        // how many rows we have

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(rowsWithoutHeader.size());

    }

    @Test
    public void getRow(){
        //print second row information
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());

        //get all rows dynamically
        for (WebElement element : driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))) {
            System.out.println(element.getText());
        }
        // get all rows dynamically second way
        List<WebElement> numrows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numrows.size(); i++) {
            WebElement rows = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-"+rows.getText());

        }

    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allcellinOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement webElement : allcellinOneRow) {
            System.out.println(webElement.getText());
        }
    }
    @Test
    public void getASingleValue(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println(cell.getText());

        WebElement cell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println(cell2.getText());
    }
    @Test
    public void printCellByIndex(){
        int rowNumber=getNumberOfRows();
        int colNumber=getNumberOfColums();

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 1; j <= colNumber; j++) {
                WebElement cell3 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.print(" "+cell3.getText());

            }
            System.out.println(" ");

        }
    }

    @Test
    public void getCellRelationToAnotherCellInSameRow(){
        String name = "Jason";
        // when we attend a value , we can find the other value
        //firstly we use a xpath that this cell value is Jason or name ,and than we find the other cell on same x path
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']//td[.='"+name+"']/../td[3]"));
        System.out.println(element.getText());


    }

    private int getNumberOfColums() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }


    private int getNumberOfRows() {
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rowsWithoutHeader.size();
    }
}
