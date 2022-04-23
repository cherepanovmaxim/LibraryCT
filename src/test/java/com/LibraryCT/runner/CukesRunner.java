package com.LibraryCT.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber/report.html",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target"},
        features = "src/test/resources/features",
        glue = "com/LibraryCT/step_defs",
        dryRun = false,
     publish = true,
        tags = ""
)
public class CukesRunner {

}