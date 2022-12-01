package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class BasePage {

   public BasePage(){
      PageFactory.initElements(Driver.getDriver(),this);
   }

   @FindBy(xpath = "//span[@class='title'][.='Books']")
   public WebElement BooksPage;
}
