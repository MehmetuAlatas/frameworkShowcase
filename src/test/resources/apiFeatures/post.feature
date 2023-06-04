@api
Feature: post users
  @apipost
  Scenario: post a new user
    Given user send a post request to the url
    And user sets the expected data
    And verifies that user should be created

