Feature: Get data from API

  Scenario: User want to get list of all objects
    Given the user has Fake REST API endpoint
    When the user retrieves the data
    Then the system returns status  301 OK
