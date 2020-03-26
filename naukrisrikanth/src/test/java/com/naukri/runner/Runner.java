package com.naukri.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

features = "E:\\eclipse-workspace\\GITHUB\\SrikanthKomirelly844863_naukri\\naukrisrikanth\\src\\main\\resources\\features\\naukritestcase.feature",
plugin = {"pretty",  "html:reports/cucumber-html-report","json:reports/cucumber-html-report/jsonreport","com.cucumber.listener.ExtentCucumberFormatter:reports/report.html"},
tags = {"@tc01_login"},

glue = {"com.stepdefiniton"},
monochrome = true
)
public class Runner {

}
	