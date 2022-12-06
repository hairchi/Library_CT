package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class US1_Step_Def_Milos {
    String actualResult;


    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection();
    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query1 = "select count(id) from users";
        DB_Util.runQuery(query1);
        actualResult = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualResult = " + actualResult);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        String query2 = "select count(distinct id) from users";
        DB_Util.runQuery(query2);
        String expectedResult = DB_Util.getCellValue(1,1);
        System.out.println("expectedResult = " + expectedResult);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
//        DB_Util.createConnection();
        String query3 = "select * from users";
        DB_Util.runQuery(query3);

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String>expectedList) {

        List<String>actualList = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(expectedList,actualList);
        System.out.println("expectedList = " + expectedList);

    }




}
