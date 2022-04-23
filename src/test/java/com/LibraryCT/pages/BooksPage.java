package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksPage {
    public BooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchField;


    @FindBy(xpath = "//tbody//td[3]")
    public WebElement nameOfBook;

    @FindBy(xpath = "//tbody//td[4]")
    public WebElement author;

    @FindBy(xpath = "//tbody//td[5]")
    public WebElement category;

    @FindBy(xpath = "//tbody//td[6]")
    public WebElement year;


    public List<String> getBookInfoFromUI() {
        List<String> list = new ArrayList<>(Arrays.asList(nameOfBook.getText(), author.getText(), category.getText(), year.getText()));
        return list;
    }


    @FindBy(xpath = "//select[@id='book_categories']/option[@value!='null']")
    public List<WebElement> booksCategories;


}
