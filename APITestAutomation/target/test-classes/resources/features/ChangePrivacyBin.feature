@tag
Feature: Change Privacy Bin with put method

  @tag1
  Scenario: Change Privacy Bin
    Given the endpoint URl 
    When I send a put request
    Then verify the Bin privacy is updated
    And status code should be success 