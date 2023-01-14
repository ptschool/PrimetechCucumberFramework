
Feature: Verify Account Information
  Verify Account Infrmation is Correct for Different Types of Accounts

  @account
  Scenario: Verify Account Details
    Given user is on the Home Page
    And user click on login button 
		Then user verify Login Page URL
		And user verify Login Page Logo
		Then user login with valid credentials
		When user dashboard page is displayed
		Then user verify Email
		And user verify Account Type
		And user verify First Name
		And user verify Last Name
		When user click logout button
		Then user verify Login Page URL
		And user verify Login Page Logo
		Then user closed the browser
