Feature: Few Examples to demonstrate PATCH API usage

  Scenario: Basic PATCH Api usage
    Given User set Content-Type header to application/json
    And User set json body to { "name": "Kaleem Urrehman", "job": "lead architect" }
    And User makes PATCH request to users/2
    Then User sees response code as 200
    And User sees response body json path to be
      | key  | value          |
      | name | Kaleem Urrehman|
      | job  | lead architect |