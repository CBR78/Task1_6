package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class LapTime {
    private LocalDateTime start;
    private LocalDateTime end;

    public LapTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public void setStartTime(LocalDateTime startTime) {
        start = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        end = endTime;
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(end, start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LapTime other = (LapTime) obj;
        return Objects.equals(end, other.end) && Objects.equals(start, other.start);
    }
    
    
    
}
