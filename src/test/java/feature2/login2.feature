Feature: User Login Functionality

Scenario: User login with valid credentials
Given user launch chrome browser
When user opens url "https://www.saucedemo.com/v1/"
And user enters username as "standard_user" and password as "secret_sauce"
And click on login
Then Page Title should be "Swag Labs"
When user clicks on menu
And click on logout
Then Page Title should be "Swag Labs"
And close browser