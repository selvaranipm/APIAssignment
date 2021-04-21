
@tag
Feature: Verify Put method for update bin
  

  @tag1
  Scenario: Updating a Bin
    Given the endpoint URl 
    When I send a put request
    Then verify the Bin is updated
    And status code should be success 

  