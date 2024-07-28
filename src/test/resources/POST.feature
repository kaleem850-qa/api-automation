Feature: Few Examples to demonstrate POST API usage

  Scenario: Basic POST Api usage
    Given User set Content-Type header to application/json
    And User set json body to { "email": "eve.holt@reqres.in", "password": "pistol" }
    And User makes POST request to register
    Then User sees response code as 200
    And User sees response body should contain token

  Scenario: Basic POST Api usage json data from resources as payload
    Given User set Content-Type header to application/json
    And User set json body from the file data/user
    When User makes POST request to users
    Then User sees response code as 201
    And User sees response body json path to be
      | key  | value     |
      | name | kaleem   |
      | job  | architect |

  Scenario Outline: Basic POST Api usage to parameterize json data from resources as payload
    Given User set Content-Type header to application/json
    And User set json body from the template file data/usertemplate with data <name>, <job>
    When User makes POST request to users
    Then User sees response code as 201
    And User sees response body json path to be
      | key  | value          |
      | name | <expectedname> |
      | job  | <expectedjob>  |

    Examples:
      | name                 | job                      | expectedname | expectedjob |
      | {#nameholder#}{kaleem}  | {#jobholder#}{developer} | kaleem          | developer   |
      | {#nameholder#}{john} | {#jobholder#}{owner}     | john         | owner       |
      | {#nameholder#}{jane} | {#jobholder#}{designer}  | jane         | designer    |





