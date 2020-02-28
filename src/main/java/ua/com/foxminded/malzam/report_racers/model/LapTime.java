package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LapTime {
    private LocalDateTime start;
    private LocalDateTime end;

    public LapTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public long getDuration() {
        return Duration.between(start, end).toMillis();
    }
}
