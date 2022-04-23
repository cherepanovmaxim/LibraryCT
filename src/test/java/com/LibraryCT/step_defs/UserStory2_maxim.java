package com.LibraryCT.step_defs;

import com.LibraryCT.pages.HomePage;
import com.LibraryCT.pages.LoginPage;
import com.LibraryCT.utilities.BrowserUtils;
import com.LibraryCT.utilities.DB_Utility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class UserStory2_maxim {
    HomePage hp = new HomePage();
    LoginPage lp = new LoginPage();
   static String borrowedBooksNumber;

    @When("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        lp.loginAsLibrarian();
    }

    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {

        BrowserUtils.sleep(4);
        borrowedBooksNumber = hp.borrowedBooksCount.getText();
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Utility.runQuery("SELECT count(*) from book_borrow where is_returned=0");


        String booksBorrowedNumberFromDB = DB_Utility.getFirstData();
//        System.out.println("books from db " + booksBorrowedNumberFromDB);

        BrowserUtils.sleep(4);


        Assert.assertEquals("Numbers are not equal",booksBorrowedNumberFromDB , borrowedBooksNumber);
    }


}
