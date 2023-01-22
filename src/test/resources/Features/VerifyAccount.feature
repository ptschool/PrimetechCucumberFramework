
Feature: Verify Account Information
  Verify Account Infrmation is Correct for Different Types of Accounts

@account
  Scenario Outline: Verify Account Details
    Given user is on the Home Page
    And user click on login button 
		Then user verify Login Page URL
		And user verify Login Page Logo
		Then user login with "<email>" and "<password>"
		When user dashboard page is displayed
		Then user verify Email is "<email>"
		And user verify Account Type is "<accountType>"
		And user verify First Name is "<firstName>"
		And user verify Last Name is "<lastName>"
		When user click logout button for account "<firstName>"
		Then user verify Login Page URL
		And user verify Login Page Logo
Examples:
	|     email        | password  |  accountType | firstName | lastName |
	|pt_test@gmail.com | Test@1234 |  Member      |  PT       | Test     |
	|pt_admin@gmail.com| Test@1234 |  Admin       | Harry     | Potter   |