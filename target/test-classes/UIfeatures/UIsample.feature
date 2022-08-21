@google
Feature: This is sample feature for parallel execution

  Scenario Outline: This sample scenario opens google
    Given User go to the "<webpage>" page
    Then User verify the page title is not empty
    And User close the browser

    Examples:
      | webpage                |
      | https://www.google.com |
