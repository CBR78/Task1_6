package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.util.SortedSet;
import java.util.TreeSet;

public class Racer {
    private String abbr;
    private String name;
    private String team;
    private LapTime lapTimeTemp;
    private SortedSet<LapTime> lapTimeSet;
    private Duration bestLap;
    
    public Racer(String string) {
        abbr = string.substring(0, 3);
        String[] array = string.substring(4).split("_");
        name = array[0];
        team = array[1];
        lapTimeSet = new TreeSet<>((o1, o2) -> o1.getDuration().compareTo(o2.getDuration()));
    }

    public void setStartTime(int numQualification, String string) {
        lapTimeTemp = new LapTime();
        lapTimeTemp.setStartTime(numQualification, string);
    }

    public void setEndTime(int numQualification, String string) {
        lapTimeTemp.setEndTime(string);
        lapTimeSet.add(lapTimeTemp);
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
