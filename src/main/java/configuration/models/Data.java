package configuration.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    Map<String, Object> data = new LinkedHashMap<>();

    @JsonAnySetter
    void setDataProperties(String key, Object value) {
        data.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getDataProperties() {
        return data;
    }
}
