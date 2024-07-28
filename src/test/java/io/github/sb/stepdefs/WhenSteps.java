package io.github.sb.stepdefs;

import io.cucumber.java8.En;
import io.restassured.http.Method;

public class WhenSteps extends BaseSteps implements En {

    public WhenSteps() {

        When("User makes GET request to {}", (String url) -> {
            api().makeRequest(Method.GET, url);
        });

        When("User makes POST request to {}", (String url) -> {
            api().makeRequest(Method.POST, url);
        });

        When("User makes PUT request to {}", (String url) -> {
            api().makeRequest(Method.PUT, url);
        });

        When("User makes DELETE request to {}", (String url) -> {
            api().makeRequest(Method.DELETE, url);
        });

        When("User makes PATCH request to {}", (String url) -> {
            api().makeRequest(Method.PATCH, url);
        });

        When("User makes {} request to url {}", (String request, String url) -> {
            api().makeRequest(Method.valueOf(request.toUpperCase()), url);
        });
    }
}
