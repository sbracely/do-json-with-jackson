package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Handling_LocalDateTime_Formats;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlingLocalDateTimeFormatsTest {
    @Test
    void whenSerializingRequest_thenUsesConfiguredDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a z", Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        JsonMapper jsonMapper = JsonMapper.builder()
                .defaultDateFormat(simpleDateFormat).withConfigOverride(LocalDateTime.class, o ->
                        o.setFormat(JsonFormat.Value.forPattern("yyyy-MM-dd HH:mm")))
                .build();
        Request request = new Request();
        Car car = new Car();
        car.setBrand("BMW");
        request.setCar(car);

        Date date = new Date(0);
        request.setDateTimePurchased(date);
        request.setLocalDateTime(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
        String json = jsonMapper.writeValueAsString(request);
        IO.println(json);
        assertThat(json)
                .contains("\"car\":{\"brand\":\"BMW\"}")
                .contains("\"dateTimePurchased\":\"1970-01-01 00:00 AM UTC\"");
    }
}
