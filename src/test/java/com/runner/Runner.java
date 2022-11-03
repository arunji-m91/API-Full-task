package com.runner;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.baseclass.BaseClass;
import com.reports.Reporting;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="",plugin = { "pretty",
		"json:target/Output.json" }, dryRun = false, snippets = SnippetType.CAMELCASE, features = "src\\test\\resources\\features", glue = "com.stepdefinition")
public class Runner extends BaseClass {
	@AfterClass
	public static void afterClass() throws IOException {
		Reporting.generateJvmReport(getProjectPath() + "\\target\\Output.json");

	}

}
