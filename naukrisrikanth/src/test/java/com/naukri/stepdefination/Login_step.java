package com.naukri.stepdefination;

import com.naukri.pages.Login_main;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_step extends Login_main {

	@Given("^user launched chrome browser$")
	public void user_launched_chrome_browser() throws Throwable {
	
		launchChrome();
	}

	@When("^user opens the Naukri homepage$")
	public void user_opens_the_Naukri_homepage() throws Throwable {
		url();

	}

	@Then("^user clicks login$")
	public void user_clicks_login() throws Throwable {
		login();

	}
}
