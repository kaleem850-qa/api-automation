Feature: Few Examples to demonstrate GET API usage

  Scenario: Basic GET Api usage
    Given User makes GET request to users/2
    Then User sees response code as 200
    Then User sees response body json path data.id should be 2

  Scenario: Query Param GET Api usage
    Given User set query parameters to
      | key  | value |
      | page | 2     |
    And User makes GET request to users
    Then User sees response code as 200
    And User sees response body json path data should be of type array with length 6

  Scenario: Cookie GET Api usage
    Given User set token cookie to abc
    And User makes GET request to users/3
    Then User sees response code as 200
    And User sees response cookie token should not exist
