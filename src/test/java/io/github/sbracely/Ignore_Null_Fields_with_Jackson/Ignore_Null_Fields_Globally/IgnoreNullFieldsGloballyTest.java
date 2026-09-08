package io.github.sbracely.Ignore_Null_Fields_with_Jackson.Ignore_Null_Fields_Globally;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import static org.assertj.core.api.Assertions.assertThat;

public class IgnoreNullFieldsGloballyTest {
    @Test
    void test() {
        JsonMapper jsonMapper = JsonMapper.builder()
                .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(JsonInclude.Include.NON_NULL))
                .changeDefaultPropertyInclusion(incl -> incl.withContentInclusion(JsonInclude.Include.NON_NULL))
                .build();
        MyDto myDto = new MyDto();
        myDto.setIntValue(123);
        String json = jsonMapper.writeValueAsString(myDto);
        IO.println(json);
        assertThat(json).doesNotContain("stringValue","null")
                .contains("intValue","123");
    }
}
