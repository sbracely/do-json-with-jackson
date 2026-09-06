package io.github.sbracely.Jackson_Annotation_Example.Jackson_General_Annotations.JsonFilter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.ser.std.SimpleBeanPropertyFilter;
import tools.jackson.databind.ser.std.SimpleFilterProvider;

public class JsonFilterTest {
    @Test
    void whenSerializingUsingJsonFilter_thenCorrect() {
        BeanWithFilter beanWithFilter = new BeanWithFilter();
        beanWithFilter.id = 1;
        beanWithFilter.name = "Test Name";

        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        simpleFilterProvider.addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

        JsonMapper jsonMapper = JsonMapper.builder().build();
        String json = jsonMapper.writer(simpleFilterProvider).writeValueAsString(beanWithFilter);
        IO.println(json);

        Assertions.assertThat(json).contains("\"name\":\"Test Name\"")
                .doesNotContain("\"id\":1");
    }
}
