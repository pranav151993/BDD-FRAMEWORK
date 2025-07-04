Feature: User Login Functionality


Background:
Given user launch chrome browser
When user opens url "https://www.saucedemo.com/v1/"

@regression               
Scenario: User login with valid credentials
And user enters username as "standard_user" and password as "secret_sauce"
And click on login
Then Page Title should be "Swag Labs"
When user clicks on menu
And click on logout
Then Page Title should be "Swag Labs"
And close browser

@sanity
Scenario: User login with invalid credentials
And user enters username as "abc" and password as "xyz"
And click on login
Then user gets invalid login error messagem "Epic sadface: Username and password do not match any user in this service1"
And close browser

Scenario: User login without any credentials
And click on login
Then user gets loginRequired error message as "Epic sadface: Username is required"
And close browser