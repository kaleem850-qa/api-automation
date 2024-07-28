package io.github.sb.stepdefs;

import io.github.sb.core.RestUtil;

public abstract class BaseSteps {

    public RestUtil api() {
        return RestUtil.INSTANCE;
    }

    public String $$(String key){
        return api().$$(key);
    }
}
