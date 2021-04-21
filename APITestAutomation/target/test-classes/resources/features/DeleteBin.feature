@tag
Feature: Verify Delete method for Delete bin
  

  @tag1
  Scenario: Deleting a Bin
    Given the endpoint URl 
    When I send a Delete request
    Then verify the Bin is Deleted
    And status code should be success 