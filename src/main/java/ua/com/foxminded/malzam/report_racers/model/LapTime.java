package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class LapTime {

    private int numQualification;
    private LocalDateTime start;
    private LocalDateTime end;
    private Duration duration;
    
    public LapTime() {
        duration = Duration.ofDays(0);
    }

    public void setStartTime(int qualification, String string) {
        numQualification = qualification;
        start = LocalDateTime.parse(string.substring(3).replace("_", "T"));
    }

    public void setEndTime(String string) {
        end = LocalDateTime.parse(string.substring(3).replace("_", "T"));
        duration = Duration.between(start, end);
    }
    
    public int getNumQualification() {
        return numQualification;
    }
    
    public Duration getDuration() {
        return duration;
    }
}
