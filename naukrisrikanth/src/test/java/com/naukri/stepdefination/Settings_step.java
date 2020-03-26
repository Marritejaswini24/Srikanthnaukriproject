package com.naukri.stepdefination;

import com.naukri.pages.Settings_main;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Settings_step extends Settings_main {
	
	@Given("^user launched  chrome$")
	public void user_launched_chrome() throws Throwable {
		launchChrome();
	}

	@When("^user opens Naukri webpage$")
	public void user_opens_Naukri_webpage() throws Throwable {
		url();
	}

	@Then("^user clicked login$")
	public void user_clicked_login() throws Throwable {
		login();
	}

	@Then("^user clicks on Settings$")
	public void user_clicks_on_Settings() throws Throwable {
		Settings();
	}

}
