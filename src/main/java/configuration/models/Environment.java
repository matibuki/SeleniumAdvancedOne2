package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import configuration.factory.EnvironmentFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    Map<String, EnvironmentFactory> environments = new LinkedHashMap<>();

    @JsonAnySetter
    void setEnvironment(String key, EnvironmentFactory environmentFactory) {
        environments.put(key, environmentFactory);
    }

    @JsonAnyGetter
    public List<EnvironmentFactory> getEnvironments() {
        return environments.values().stream().toList();
    }
}
