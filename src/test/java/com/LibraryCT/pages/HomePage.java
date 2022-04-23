package com.LibraryCT.pages;

import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_count")
    public WebElement usersCount;

    @FindBy(id = "book_count")
    public WebElement booksCount;


    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksCount;

    @FindBy(xpath = "//span[text()='Books']")
    public WebElement booksNavigationTab;

    @FindBy(xpath = "//ul[@id='menu_item']")
    public List<WebElement> navigationBar;


    public void clickTabFromNavigationBar(String name) {

        Driver.getDriver().findElement(By.xpath("//ul[@id='menu_item']//span[text()='" + name + "']")).click();
    }

}
