package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LapTime {
    private LocalDateTime start;
    private Duration duration;

    public LapTime(String startTime) {
        start = LocalDateTime.parse(startTime.substring(3).replace("_", "T"));
    }

    public void setEndTime(String endTime) {
        LocalDateTime end = LocalDateTime.parse(endTime.substring(3).replace("_", "T"));
        duration = Duration.between(start, end);
    }

    public Duration getDuration() {
        return duration;
    }
}
