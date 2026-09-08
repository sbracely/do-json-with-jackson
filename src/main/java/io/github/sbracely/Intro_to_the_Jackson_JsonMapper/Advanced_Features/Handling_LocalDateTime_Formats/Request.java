package io.github.sbracely.Intro_to_the_Jackson_JsonMapper.Advanced_Features.Handling_LocalDateTime_Formats;

import java.time.LocalDateTime;
import java.util.Date;

public class Request {
    private Car car;
    private Date dateTimePurchased;
    private LocalDateTime localDateTime;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDateTimePurchased() {
        return dateTimePurchased;
    }

    public void setDateTimePurchased(Date dateTimePurchased) {
        this.dateTimePurchased = dateTimePurchased;
    }
}
