@tag
Feature: Verify Get method for versionscount
  

  @tag1
  Scenario: Version count
    Given the endpoint URl 
    When I send a get request
    Then verify the count
    And status code should be success 