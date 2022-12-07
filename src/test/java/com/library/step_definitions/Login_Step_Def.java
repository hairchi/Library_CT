package com.library.step_definitions;

import com.library.pages.LoginPage;
import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.configuration.Configuration;

public class Login_Step_Def {
    LoginPage loginPage = new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("user enters username {string} and passcode {string} and clicks the login button")
    public void user_enters_username_and_passcode_and_clicks_the_login_button(String email, String password) {
        loginPage.login(email,password);
    }

}
