package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

//    @FindBy(xpath = "//div/h2[@id='borrowed_books']")
//    public WebElement borrowedBooksNumber;

    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksNumber;

    @FindBy(id = "user_count")
    public WebElement usersNumber;

    @FindBy(id = "book_count")
    public WebElement booksNumber;


    public Dashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
