package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.TreeSet;

public class Racer {
    private String abbr;
    private String name;
    private String team;
    private SortedSet<LapTime> lapTimeSet;
    private LapTime tempLapTime;

    public Racer(String abbr, String name, String team) {
        this.abbr = abbr;
        this.name = name;
        this.team = team;
        lapTimeSet = new TreeSet<>((o1, o2) -> o1.getDuration().compareTo(o2.getDuration()));
    }

    public void setStartTime(LocalDateTime startTime) {
        tempLapTime = new LapTime();
        tempLapTime.setStartTime(startTime);
    }

    public void setEndTime(LocalDateTime endTime) {
        tempLapTime.setEndTime(endTime);
        lapTimeSet.add(tempLapTime);
    }

    public String getAbbr() {
        return abbr;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public Duration getBestLap() {
        return lapTimeSet.first().getDuration();
    }
}
