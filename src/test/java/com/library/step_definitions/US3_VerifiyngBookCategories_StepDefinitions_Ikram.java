package com.library.step_definitions;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtils;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US3_VerifiyngBookCategories_StepDefinitions_Ikram {

    LoginPage loginPage = new LoginPage();
    BookPage  bookPage = new BookPage();
    BasePage basePage = new BasePage();
    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login("librarian59@library", "DmSqxDEJ");
    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String string) {
        basePage.BooksPage.click();

    }
    List<String>actualCategories;

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
       /*
        Select select = new Select(bookPage.BookCategoriesDrpDn);
        actualCategories= select.getAllSelectedOptions();
        actualCategories.remove(0);
        System.out.println("actualCategories = " + actualCategories);

        */

        actualCategories = BrowserUtils.getAllSelectOptions(bookPage.BookCategoriesDrpDn);
        actualCategories.remove(0);
        System.out.println("actualCategories = " + actualCategories);




    }
    List<String> expectedCategories;
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.createConnection();
        String query = "select name from book_categories;";
        DB_Util.runQuery(query);
        expectedCategories = DB_Util.getColumnDataAsList("name");


    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        Assert.assertEquals(expectedCategories,actualCategories);
        DB_Util.destroy();

    }


}
