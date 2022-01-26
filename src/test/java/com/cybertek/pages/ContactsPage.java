package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactsPage extends BasePage{

    //since we re extending BasePAge we do not expilicit constructor for this class

  //  @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
  //  public WebElement email;

    public WebElement getContactEmail(String email){
        String xpath="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
