package com.LibraryCT.step_defs;

import com.LibraryCT.utilities.DB_Utility;
import com.LibraryCT.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


    public class Hooks {




       @After
        public void tearDown(Scenario scenario) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

            Driver.closeDriver();
           // DB_Utility.destroy();
        }



    }


