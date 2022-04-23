package com.LibraryCT.step_defs;

import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory3_maxim {


    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {

        DB_Utility.runQuery("SELECT bc.name, count(*) From books b inner join book_categories bc on b.book_category_id = bc.id group by bc.name order by 2 DESC");


    }
    @Then("verify that {string} is the most popular book genre.")
    public void verify_that_classic_is_the_most_popular_book_genre(String genre) {
        DB_Utility.runQuery("SELECT bc.name, count(*) From books b inner join book_categories bc on b.book_category_id = bc.id group by bc.name order by 2 DESC");
//
//        System.out.println("жанр " +DB_Utility.getFirstData());

        BrowserUtils.sleep(4);
   Assert.assertEquals("THE most popular genre is: " + DB_Utility.getFirstData(), genre, DB_Utility.getFirstData());
    }
}
