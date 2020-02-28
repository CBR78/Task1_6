package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LapTime {
    private LocalDateTime start;
    private LocalDateTime end;

    public void setStartTime(LocalDateTime startTime) {
        start = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        end = endTime;
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }
}
