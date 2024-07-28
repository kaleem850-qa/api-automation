package io.github.sb.core;

import io.github.sb.error.PropertyFileNotFound;
import io.github.sb.error.PropertyKeyNotFound;
import io.github.sb.model.Act;
import io.github.sb.util.Auth;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.*;

import static io.restassured.RestAssured.given;
import static java.lang.ThreadLocal.withInitial;

public enum RestUtil {

    INSTANCE;

    private static final String REQUEST = "REQUEST";
    private static final String RESPONSE = "RESPONSE";
    private static String ENV = System.getProperty("env", "dev");
    private static ResourceBundle resourceBundle = ENV.equals("") ? null : getResourceBundle();
    private final ThreadLocal<Map<String, Object>> apiInstances = withInitial(HashMap::new);

    public <T> T get(String name) {
        return (T) apiInstances.get()
                .get(name);
    }

    public <T> T set(String name, T object) {
        apiInstances.get()
                .put(name, object);
        return object;
    }

    public RequestSpecification getRequest() {
        if (null == get(REQUEST)) {
            String baseUri = baseUri();
            set(REQUEST, resourceBundle == null && baseUri == null ? given().log()
                    .all() : given().baseUri(baseUri).log().all());
        }

        return get(REQUEST);
    }

    public Response getResponse() {
        return get(RESPONSE);
    }

    public Response setResponse(Response response) {
        return set(RESPONSE, response);
    }

    public void setHeader(Header header) {
        set(REQUEST, getRequest().header(header));
    }

    public void setHeaders(Headers headers) {
        set(REQUEST, getRequest().headers(headers));
    }

    public void setCookie(String cookie) {
        set(REQUEST, getRequest().cookie(cookie));
    }

    public void setCookie(Cookie cookie) {
        set(REQUEST, getRequest().cookie(cookie));
    }

    public void setCookies(Cookies cookies) {
        set(REQUEST, getRequest().cookies(cookies));
    }

    public void setAuth(Auth authType, String userName, String password) {
        switch (authType) {
            case FORM:
                set(REQUEST, getRequest().auth().form(userName, password));
                break;
            case BASIC:
                set(REQUEST, getRequest().auth().basic(userName, password));
                break;
            case DIGEST:
                set(REQUEST, getRequest().auth().digest(userName, password));
                break;
            case PREEMPTIVE:
                set(REQUEST, getRequest().auth().preemptive().basic(userName, password));
                break;
            default:
                break;
        }
    }

    public void setQueryParams(List<Act> params) {
        params.forEach(param -> set(REQUEST, getRequest().queryParam(param.getKey(), $$(param.getValue().toString()))));
    }

    public void setFormParams(List<Act> formParams) {
        formParams.forEach(formParam -> set(REQUEST, getRequest().formParam(formParam.getKey(), $$(formParam.getValue().toString()))));
    }

    public void setBody(String body) {
        set(REQUEST, getRequest().body(body));
    }

    public void makeRequest(Method reqType, String url) {
        Response response = getRequest().request(reqType, url);
        set(RESPONSE, response);
    }

    private String baseUri() {
        try {
            return resourceBundle.getString("baseuri");
        } catch (MissingResourceException ex) {
            return null;
        }
    }

    public String $$(String key) {
        try {
            if (key.startsWith("$$"))
                return resourceBundle.getString(key.replace("$$", ""));
            return key;
        } catch (MissingResourceException ex) {
            throw new PropertyKeyNotFound("Key " + key + " not found in the property file: " + ex.getMessage());
        }
    }

    private static ResourceBundle getResourceBundle() {
        try {
            return ResourceBundle.getBundle("env/config-" + ENV);
        } catch (MissingResourceException ex) {
            throw new PropertyFileNotFound("File not found exception: " + ex.getMessage());
        }
    }


    public void reset() {
        apiInstances.get()
                .clear();
    }

}
