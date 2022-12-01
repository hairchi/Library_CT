package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputEmail;

    @FindBy(xpath ="//input[@id='inputPassword']" )
    public WebElement inputPassword;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;

    public void login(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
}
