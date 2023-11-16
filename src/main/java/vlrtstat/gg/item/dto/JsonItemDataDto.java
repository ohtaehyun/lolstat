package vlrtstat.gg.item.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonItemDataDto {
    private Map<String, JsonItemDto> data;

    public Map<String, JsonItemDto> getData() {
        return data;
    }

    public void setData(Map<String, JsonItemDto> data) {
        this.data = data;
    }
}
