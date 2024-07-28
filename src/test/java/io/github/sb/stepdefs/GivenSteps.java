package io.github.sb.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.github.sb.model.Act;
import io.github.sb.util.Auth;
import io.github.sb.util.FileToString;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GivenSteps extends BaseSteps implements En {

    public GivenSteps() {

        Given("User set {} header to {}", (String headerKey, String headerValue) -> {
            Header header = new Header(headerKey, $$(headerValue));
            api().setHeader(header);
        });

        Given("User set headers to", (DataTable headers) -> {
            List<Act> headerList = headers.asList(Act.class);
            List<Header> headersFinal = headerList.stream().map(header -> new Header(header.getKey(), $$(header.getValue().toString()))).collect(Collectors.toList());
            api().setHeaders(new Headers(headersFinal));
        });

        Given("User set cookie to {}", (String cookie) -> {
            api().setCookie($$(cookie));
        });

        Given("User set {} cookie to {}", (String cookieKey, String cookieValue) -> {
            Cookie cookie = new Cookie.Builder(cookieKey, $$(cookieValue)).build();
            api().setCookie(cookie);
        });

        Given("User set cookies to", (DataTable cookies) -> {
            List<Act> cookiesList = cookies.asList(Act.class);
            List<Cookie> cookiesFinal = cookiesList.stream().map(cookie -> new Cookie.Builder(cookie.getKey(), $$(cookie.getValue().toString())).build()).collect(Collectors.toList());
            api().setCookies(new Cookies(cookiesFinal));
        });

        Given("User set basic authentication to {} and {}", (String userName, String password) -> {
            api().setAuth(Auth.BASIC, $$(userName), $$(password));
        });

        Given("User set form authentication to {} and {}", (String userName, String password) -> {
            api().setAuth(Auth.FORM, $$(userName), $$(password));
        });

        Given("User set preemptive authentication to {} and {}", (String userName, String password) -> {
            api().setAuth(Auth.PREEMPTIVE, $$(userName), $$(password));
        });

        Given("User set digest authentication to {} and {}", (String userName, String password) -> {
            api().setAuth(Auth.DIGEST, $$(userName), $$(password));
        });

        Given("User set query parameters to", (DataTable params) -> {
            List<Act> paramsList = params.asList(Act.class);
            api().setQueryParams(paramsList);
        });

        Given("User set form parameters to", (DataTable formParams) -> {
            List<Act> formParamsList = formParams.asList(Act.class);
            api().setFormParams(formParamsList);
        });

        Given("User set json body from the file {}", (String jsonPath) -> {
            api().setBody(FileToString.CONTENT(jsonPath));
        });

        Given("User set json body from the template file {} with data {}", (String jsonPath, String data) -> {
            String json = FileToString.CONTENT(jsonPath);
            if(data != null) {
                Map<String, String> dataMap = Arrays.stream(StringUtils.chop(data.trim()).split("},"))
                        .map(str -> str.split("}\\{"))
                        .collect(Collectors.toMap(str -> str[0].trim().substring(1), str -> str[1].trim()));

                for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                    json = json.replaceAll(entry.getKey(), entry.getValue());
                }
            }
            api().setBody(json);
        });

        Given("User set json body to {}", (String body) -> {
            api().setBody(body);
        });
    }

}
