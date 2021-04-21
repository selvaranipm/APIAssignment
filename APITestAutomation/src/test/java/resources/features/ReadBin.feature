
@tag
Feature: Verify Get method for Read bin
  

  @tag1
  Scenario: Updating a Bin
    Given the endpoint URl 
    When I send a get request
    Then verify the Bin is read
    And status code should be success 
 
