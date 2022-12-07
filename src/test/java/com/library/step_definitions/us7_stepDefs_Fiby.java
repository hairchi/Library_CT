package com.library.step_definitions;

import com.library.pages.*;
import com.library.utility.BrowserUtils;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class us7_stepDefs_Fiby {

    LoginPage loginPage = new LoginPage();
    BookPage1 bookPage = new BookPage1();
    BasePage1 basePage = new BasePage1();
    BorrowPage borrowPage = new BorrowPage();

    @Given("I login as a student")
    public void i_login_as_a_student() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
       // loginPage.login("student60@library", "AoSFw44Y");

    }

    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
        basePage.BooksPage.click();

    }

    @Given("I search book name called {string}")
    public void i_search_book_name_called(String string) {
        bookPage.search.sendKeys(string);
        BrowserUtils.waitFor(3);
    }
    @When("I click Borrow {string}")
    public void iClickBorrow(String book) {
        bookPage.borrowBookBtn(book);
    }

    @Then("verify that {string} is shown in \"Borrowing Books” page")
    public void verifyThatIsShownInBorrowingBooksPage(String bookname) {

        borrowPage.borrowBooks.click();
        // return a list of string from a list of elements
        System.out.println(BrowserUtils.getElementsText(borrowPage.allBorrowedBooks));

     Assert.assertTrue(BrowserUtils.getElementsText(borrowPage.allBorrowedBooks).contains(bookname));

        //------------------------------------------------------------
//        actualBookName= borrowPage.bookName(bookname).getText();
//        System.out.println("actualBookName = " + actualBookName);
//        String expectedName = "Head First Java";
//        Assert.assertEquals(expectedName, actualBookName);
        //---------------------------------------------------------------

    }


    @And("verify logged student has {string} in database")
    public void verifyLoggedStudentHasInDatabase(String bookname) {

        // get data from UI
        System.out.println("---- DATA FROM UI ---- ");
        String actualBookName = borrowPage.bookName(bookname).getText();
        System.out.println("actualBookName = " + actualBookName);
        String actualUser = borrowPage.user.getText();
        System.out.println("actualUser = " + actualUser);

        // get data from DB
        String query = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                " inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 60'\n" +
                "order by 3 desc";
        DB_Util.runQuery(query);

        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        System.out.println("---- DATA FROM DATABASE ---- ");
        String expectedUser = bookInfo.get("full_name");
        System.out.println("expectedUser = " + expectedUser);
        String expectedBookName = bookInfo.get("name");
        System.out.println("expectedBookName = " + expectedBookName);

        //compare
        Assert.assertEquals(expectedBookName, actualBookName);
        Assert.assertEquals(expectedUser, actualUser);

    }
}
