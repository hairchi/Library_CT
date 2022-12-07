package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookPage extends BasePage{
    public BookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")
    public WebElement addBookButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement author;
    //dropdown including ALL option
    @FindBy(id = "book_categories")
    public WebElement bookCategoryDropDown;
    //dropdown without ALL option
    @FindBy(xpath = "//select[@id='book_categories']/option/following-sibling::option")
    public WebElement categoryDropDown;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesBtn;



    @FindBy(xpath = "//select[@name='tbl_books_length']")
    public WebElement expandPageDropDown;

    @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> listOfBooks;


    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement toastMessage;


}

