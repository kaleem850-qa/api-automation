package io.github.sb.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.sb.model.Act;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class ThenSteps extends BaseSteps implements En {

    public ThenSteps() {

        //Response Codes
        Then("User sees response code as {int}", (Integer code) -> {
            api().getResponse().then().statusCode(code);
        });

        Then("User sees response code should not be {int}", (Integer code) -> {
            Assert.assertNotEquals(code, Integer.valueOf(api().getResponse().getStatusCode()));
        });

        //Response Body
        Then("User sees response body should be {}", (String bodyString) -> {
            Assert.assertEquals(bodyString, api().getResponse().getBody().asString());
        });

        Then("User sees response body should contain {}", (String bodyString) -> {
            assertThat(api().getResponse().getBody().asString(), containsString(bodyString));
        });

        Then("User sees response body should not contain {}", (String bodyString) -> {
            assertThat(api().getResponse().getBody().asString(), not(containsString(bodyString)));
        });

        Then("User sees response body json path to be", (DataTable response) -> {
            List<Act> responseList = response.asList(Act.class);
            responseList.forEach(res -> api().getResponse().then().body(res.getKey(), equalTo(res.getValue())));
        });

        Then("User sees response body json path {} should be {string}", (String path, String value) -> {
            api().getResponse().then().body(path, equalTo(value));
        });

        Then("User sees response body json path {} should be {int}", (String path, Integer value) -> {
            api().getResponse().then().body(path, equalTo(value));
        });

        Then("User sees response body json path {} should not be {string}", (String path, String value) -> {
            api().getResponse().then().body(path, not(equalTo(value)));
        });

        Then("User sees response body json path {} should not be {int}", (String path, Integer value) -> {
            api().getResponse().then().body(path, not(equalTo(value)));
        });

        Then("User sees response body json path {} should be of type array", (String path) -> {
            api().getResponse().then().body(path, isA(List.class));
        });

        Then("User sees response body json path {} should be of type array with length {int}", (String path, Integer size) -> {
            api().getResponse().then().body(path, hasSize(size));
        });


        //Response Headers
        Then("User sees response header {} should exist", (String header) -> {
            assertThat(api().getResponse().getHeader(header), is(notNullValue()));
        });

        Then("User sees response header {} should not exist", (String header) -> {
            assertThat(api().getResponse().getHeader(header), is(nullValue()));
        });

        Then("User sees response header {} should be {}", (String headerKey, String headerValue) -> {
            assertThat(api().getResponse().getHeader(headerKey), is(headerValue));
        });

        Then("User sees response header {} should not be {}", (String headerKey, String headerValue) -> {
            assertThat(api().getResponse().getHeader(headerKey), not(is(headerValue)));
        });

        //Response Cookies
        Then("User sees response cookie {} should exist", (String cookie) -> {
            assertThat(api().getResponse().getCookie(cookie), is(notNullValue()));
        });

        Then("User sees response cookie {} should not exist", (String cookie) -> {
            assertThat(api().getResponse().getCookie(cookie), is(nullValue()));
        });

        Then("User sees response cookie {} should be {}", (String cookieKey, String cookieValue) -> {
            assertThat(api().getResponse().getCookie(cookieKey), is(cookieValue));
        });

        Then("User sees response cookie {} should not be {}", (String cookieKey, String cookieValue) -> {
            assertThat(api().getResponse().getCookie(cookieKey), not(is(cookieValue)));
        });

        //Stores
        Then("User stores value of response header {} as {}", (String headerKey, String ref) -> {
            System.setProperty(ref, api().getResponse().getHeader(headerKey));
        });

        Then("User stores value of response body json path {} as {}", (String path, String ref) -> {
            System.setProperty(ref, JsonPath.from(api().getResponse().getBody().asString()).getString(path));
        });


    }
}
