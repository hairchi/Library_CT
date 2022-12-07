package com.library.step_definitions;


import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After
    public void teardownScenario(Scenario scenario){
        // We will implement taking screenshot in this method
        //System.out.println("It will be closing browser using cucumber @After each scenario");

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }


    //@Before
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
        Driver.getDriver().get("URL of your app");
    }


    //@Before (value = "@login", order=2)
    public void setupForLogin(){
        // If you want any code to run before any specific feature/scenario,
        // you can use value= "@tagname" to determine this
        System.out.println("====this will only apply to scenarios with @login tag");
    }

    //@Before (value="@db" , order=3)
    public void setupDatabaseScenario(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }

    //@BeforeStep
    public void setupScenarioStep(){

        System.out.println("--------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }
    //@After("@db")
    public void destroy(){
        DB_Util.destroy();
        System.out.println("Closing data base connection");
    }
    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    //@Before("@db")
    public void setupDB(){
        DB_Util.createConnection();
        System.out.println("Connecting to data base");
    }



//    @Before("@db")
//    public void stepDB(){
//        DB_Util.createConnection();
//        System.out.println("connecting to database...");
//    }
//
//    @After("@db")
//    public void destroyDB(){
//        DB_Util.destroy();
//        System.out.println("closing connection...");
//    }

}