Feature: Few Examples to demonstrate PUT API usage

  Scenario: Basic PUT Api usage
    Given User set Content-Type header to application/json
    And User set json body to { "name": "kaleem", "job": "manager" }
    And User makes PUT request to users/2
    Then User sees response code as 200
    And User sees response body json path to be
      | key  | value   |
      | name | kaleem   |
      | job  | manager |