package com.library.step_definitions;

import com.library.pages.Dashboard;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_Olena_BorrowedBooksNumber_Step_Def {

    String actualBorrowedBooksNumber;
    LoginPage loginPage = new LoginPage();
    Dashboard dashboard = new Dashboard();

    @Given("user login as a {string}")
    public void user_login_as_a_librarian(String userType) {
        loginPage.login(userType);
    }

    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
//        Expected --> Database
//        Actual   --> UI
        actualBorrowedBooksNumber = dashboard.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        //   1 -  Make connection
        //   DB_Util.createConnection(); --> Since we have custom hooks(@Before("@db")) we don't need to connect database from step defs

        //Run Query
        DB_Util.runQuery("select count(*) as borrowedBooks\n" +
                "from book_borrow\n" +
                "where is_returned = 0;");

        //Store Data
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);

        //Compare
        Assert.assertEquals(expectedBorrowedBooksNumber, actualBorrowedBooksNumber);

        // Close Connection
        // DB_Util.destroy(); --> @After("@db") will close connections

    }
}
