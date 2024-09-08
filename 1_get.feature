Feature: Get data
Scenario: User want to get list of all users
Given the user has the Fake REST API endpoint
When the user retrieves user data
Then the system returns status code 200OK
