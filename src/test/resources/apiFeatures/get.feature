 @api
Feature: get users
  @apiget
  Scenario: get a specific user
    Given user send a GET Request to the url
    Then HTTP Status Code should be 200
    And Content Type should be JSON
