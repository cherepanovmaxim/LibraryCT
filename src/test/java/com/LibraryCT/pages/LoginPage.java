package com.LibraryCT.pages;

import com.LibraryCT.utilities.ConfigurationReader;
import com.LibraryCT.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement loginField;

    @FindBy(id = "inputPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInBTN;


    public void loginAsLibrarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginField.sendKeys(ConfigurationReader.getProperty("librarianUsername"));
        passwordField.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        signInBTN.click();
    }

    public void loginAsStudent() {
        loginField.sendKeys(ConfigurationReader.getProperty("studentUsername"));
        passwordField.sendKeys(ConfigurationReader.getProperty("studentPassword"));
        signInBTN.click();
    }


}
