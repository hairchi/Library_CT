package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BorrowPage {

    public BorrowPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='title'][.='Borrowing Books']")
      public WebElement borrowBooks;

    @FindBy(xpath = "//tbody//td[2]")
      public List<WebElement> allBorrowedBooks;

 @FindBy(id ="user_list")
    public WebElement user;


    public WebElement bookName(String bookName) {
        String xpath = "//td[2][.='" + bookName + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

}
