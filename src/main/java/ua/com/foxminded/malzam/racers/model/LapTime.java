package ua.com.foxminded.malzam.racers.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class LapTime {
    private final LocalDateTime start;
    private final LocalDateTime end;

    public LapTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public long getDuration() {
        return Duration.between(start, end).toMillis();
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

    @Override
    public String toString() {
        return "LapTime [start=" + start + ", end=" + end + "]";
    }
}
