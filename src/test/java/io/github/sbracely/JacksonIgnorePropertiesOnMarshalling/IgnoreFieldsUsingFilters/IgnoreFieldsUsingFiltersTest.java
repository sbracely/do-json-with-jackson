package io.github.sbracely.JacksonIgnorePropertiesOnMarshalling.IgnoreFieldsUsingFilters;

import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class IgnoreFieldsUsingFiltersTest {
    @Test
    void shouldIgnoreExcludedFieldWhenSerializingWithFilter() {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("intValue");
        SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", filter);
        JsonMapper jsonMapper = JsonMapper.builder()
                .filterProvider(filterProvider)
                .build();
        MyDtoWithFilter dto = new MyDtoWithFilter();
        dto.setIntValue(123);
        dto.setString("string");
        String json = jsonMapper.writeValueAsString(dto);
        IO.println(json);
        assertThat(json).doesNotContain("intValue", "123")
                .contains("string");
    }
}
