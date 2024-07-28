Feature: Few Examples to demonstrate DELETE API usage

  Scenario: Basic DELETE Api usage
    Given User set Content-Type header to application/json
    And User makes DELETE request to users/2
    Then User sees response code as 204