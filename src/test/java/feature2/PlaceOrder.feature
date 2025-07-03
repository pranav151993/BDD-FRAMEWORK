Feature: Add Product to Cart


Background:
Given user launch chrome browser
When user opens url "https://www.saucedemo.com/v1/"

Scenario: Add new product to cart
And user enters username as "standard_user" and password as "secret_sauce"
And click on login
Then product name "Sauce Labs Bolt T-Shirt" should be available in products.
And price of the product should be "$15.99"
Then User clicks on product name.
And User clicks on Add to cart.
And User clicks on Cart
Then "DESCRIPTION" of product is visible
And Description of product is "Sauce Labs Bolt T-Shirt"
And close browser

Scenario: Remove product from cart
And user enters username as "standard_user" and password as "secret_sauce"
And click on login
Then User clicks on product name.
And User clicks on Add to cart.
And User clicks on Cart
And User clicks on Remove
Then Description of product "Sauce Labs Bolt T-Shirt" should not visible
And close browser

Scenario: place order of the product
And user enters username as "standard_user" and password as "secret_sauce"
And click on login
Then product name "Sauce Labs Bolt T-Shirt" should be available in products.
And price of the product should be "$15.99"
Then User clicks on product name.
And User clicks on Add to cart.
And User clicks on Cart
Then "DESCRIPTION" of product is visible
And Description of product is "Sauce Labs Bolt T-Shirt"
And click on checkout
And enter "First Name" and "Last Name" & "postal Code"
And Click Continue
Then Verify Total Price is "Total: $17.27"
And click on Finish
Then Verify the text "THANK YOU FOR YOUR ORDER"




