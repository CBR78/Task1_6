package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.util.SortedSet;
import java.util.TreeSet;

public class Racer {
    private String abbr;
    private String name;
    private String team;
    private LapTime tempLapTime;
    private SortedSet<LapTime> lapTimeSet;
    private Duration bestLap;

    public Racer(String abbr, String name, String team) {
        this.abbr = abbr;
        this.name = name;
        this.team = team;
        lapTimeSet = new TreeSet<>((o1, o2) -> o1.getDuration().compareTo(o2.getDuration()));
    }

    public void setStartTime(String startTime) {
        tempLapTime = new LapTime(startTime);
    }

    public void setEndTime(String endTime) {
        tempLapTime.setEndTime(endTime);
        lapTimeSet.add(tempLapTime);
        bestLap = lapTimeSet.first().getDuration();
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
        return bestLap;
    }
}
