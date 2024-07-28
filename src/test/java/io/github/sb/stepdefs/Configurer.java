package io.github.sb.stepdefs;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.github.sb.model.Act;

import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Act.class,(Map<String, String> row) -> new Act(row.get("key"), row.get("value"))));
    }

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

}
