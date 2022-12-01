package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {
    public BookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "book_categories")
    public WebElement BookCategoriesDrpDn;

}
