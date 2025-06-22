Feature: Vendor search Filter on Bstackdemo.com


Background:
Given user launch chrome browser
When user opens url "https://bstackdemo.com/"

Scenario Outline: Search mobile by vendor filter
When user choose "<vendorName>"
Then mobile of respective "<vendorBrand>" should show

Examples:
|vendorName|vendorBrand|
| Apple    |iphone|
| Google   |pixel |
|Samsung   |Galaxy|
|Oneplus   |One Plus|