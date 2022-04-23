package com.LibraryCT.step_defs;

import com.LibraryCT.pages.BooksPage;
import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserStory6_maxim {

    LoginPage lp = new LoginPage();
    HomePage hp = new HomePage();
    BooksPage bp = new BooksPage();
   static List<String> booksCategoriesList = new ArrayList<>();
   static List<String> dataFromDB = new ArrayList<>();


    @Given("login as a librarian")
    public void login_as_a_librarian() {
        lp.loginAsLibrarian();
    }

    @When("navigate to {string} page")
    public void navigate_to_page(String string) {
        hp.clickTabFromNavigationBar(string);
    }

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {

        BrowserUtils.sleep(4);
        for (WebElement each : bp.booksCategories) {
            booksCategoriesList.add(each.getText());
        }

    }

    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Utility.createConnection("jdbc:mysql://34.230.35.214:3306/library2", "library2_client", "6s2LQQTjBcGFfDhY");
        DB_Utility.runQuery("SELECT name From book_categories");

        dataFromDB = DB_Utility.getColumnDataAsList(1);

    }

    @Then("verify book categories from UI match the book_categories table from DB.")
    public void verify_book_categories_from_ui_match_the_book_categories_table_from_db() {

        Assert.assertEquals(booksCategoriesList, dataFromDB);
    }
}
