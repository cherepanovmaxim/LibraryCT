package com.LibraryCT.step_defs;

import com.LibraryCT.utilities.DB_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

public class UserStory1_maxim {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Utility.createConnection("jdbc:mysql://34.230.35.214:3306/library2", "library2_client", "6s2LQQTjBcGFfDhY");
    }

    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Utility.runQuery("Select id From users");
    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {

        List<String> listOfId = DB_Utility.getColumnDataAsList(1);
        Set<String> duplicates = new LinkedHashSet<>();
        boolean unique = true;
        for (String each : listOfId) {
            if (Collections.frequency(listOfId, each) > 1) {
                unique = false;
                duplicates.add(each);
            }
        }


        if (!duplicates.isEmpty()) System.out.println("Duplicates: " + duplicates);

        Assert.assertTrue("RESULT OF TEST IS: no duplicates? " + unique, unique);

    }


    // scenario #2

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {

        DB_Utility.runQuery("Select * From users");

    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> dataList) {

        List<String> columnNames = DB_Utility.getColumnNames();

        Assert.assertEquals(dataList, columnNames);
    }

}
