package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.*;
import com.library.utility.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class us6_AddingBook_Step_Def_Katya {
    String expectedBookName;
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @Given("User logs in as librarian")
    public void userLogsInAsLibrarian() {
        loginPage.login(ConfigurationReader.getProperty("librarian_username"),ConfigurationReader.getProperty("librarian_password"));


        //loginPage.login("librarian", "librarian");
    }

    @Given("Librarian navigates to {string} page")
    public void librarian_navigates_to_page(String moduleName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
        wait.until(ExpectedConditions.visibilityOf(bookPage.books));
        bookPage.books.click();
        BrowserUtils.sleep(3);


    }

    @When("Librarian clicks to add book")
    public void librarian_clicks_to_add_book() {;
        bookPage.addBookButton.click();

    }

    @When("Librarian enters book name {string}")
    public void librarian_enters_book_name(String bookName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
        wait.until(ExpectedConditions.visibilityOf(bookPage.bookName));

        bookPage.bookName.sendKeys(bookName);
    }

    @When("Librarian enters ISBN {string}")
    public void librarian_enters_isbn(String isbn) {
        bookPage.isbn.sendKeys(isbn);

    }

    @When("Librarian enters year {string}")
    public void librarian_enters_year(String year) {
        bookPage.year.sendKeys(year);

    }

    @When("Librarian enters author {string}")
    public void librarian_enters_author(String author) {
        bookPage.author.sendKeys(author);
    }

    @When("Librarian chooses the book category {string}")
    public void librarian_chooses_the_book_category(String bookCategory) {
        Select select = new Select(bookPage.bookCategoryDropDown);
        select.selectByVisibleText(bookCategory);

    }

    @When("Librarian clicks to save changes")
    public void librarian_clicks_to_save_changes() {

        bookPage.saveChangesBtn.click();
    }

    @Then("Librarian verify new book by {string}")
    public void librarian_verify_new_book_by(String bookName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(bookPage.toastMessage));
        String expectedMessage = "The book has been created.";
        String actualMessage = bookPage.toastMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

 }

        @Then("Librarian verify new book from database by {string}")
        public void librarian_verify_new_book_from_database_by (String bookName){
            DB_Util.createConnection();

            DB_Util.runQuery("select * from books\n" +
                    "where name='"+bookName+"';");

            String actualBookName = bookName;
            String expectedBookName = DB_Util.getCellValue(1,2);
            Assert.assertEquals(expectedBookName,actualBookName);

        }

    }

