#### Then Steps

Gherkin Expressions|Example
--- | ---
**Then** User sees response code as {int}|**Then** User sees response code as `200`
**Then** User sees response code should not be {int}|**Then** User sees response code should not be `200`
**Then** User sees response body should be {}|**Then** User sees response body should be `someString`
**Then** User sees response body should contain {}|**Then** User sees response body should contain `someString`
**Then** User sees response body should not contain {}|**Then** User sees response body should not contain someString`
**Then** User sees response body json path to be|**Then** User sees response body json path to be
**Then** User sees response body json path {} should be {string}|**Then** User sees response body json path `data.name.firstname` should be `"karl"`
**Then** User sees response body json path {} should be {int}|**Then** User sees response body json path `data.id` should be `323`
**Then** User sees response body json path {} should not be {string}|**Then** User sees response body json path `data.name.firstname` should not be `"someString"`
**Then** User sees response body json path {} should not be {int}|**Then** User sees response body json path `data.id` should not be `324`
**Then** User sees response body json path {} should be of type array|**Then** User sees response body json path `data.values` should be of type array
**Then** User sees response body json path {} should be of type array with length {int}|**Then** User sees response body json path `data.values` should be of type array with length `9`
**Then** User sees response header {} should exist|**Then** User sees response header `someHeader` should exist
**Then** User sees response header {} should not exist|**Then** User sees response header `someHeader` should not exist
**Then** User sees response header {} should be {}|**Then** User sees response header `someHeader` should be `someString`
**Then** User sees response header {} should not be {}|**Then** User sees response header `someHeader` should not be `someString`
**Then** User sees response cookie {} should exist|**Then** User sees response cookie `someCookie` should exist
**Then** User sees response cookie {} should not exist|**Then** User sees response cookie `someCookie` should not exist
**Then** User sees response cookie {} should be {}|**Then** User sees response cookie `someCookie` should be `someString`
**Then** User sees response cookie {} should not be {}|**Then** User sees response cookie `someCookie` should not be `someString`
**Then** User stores value of response header {} as {}|**Then** User stores value of response header `someHeader` as {}
**Then** User stores value of response body json path {} as {}|**Then** User stores value of response body json path `data.id` as {}