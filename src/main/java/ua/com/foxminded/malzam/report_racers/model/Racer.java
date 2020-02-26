package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.util.Map;
import java.util.SortedMap;

public class Racer {
    public Map<String, String[]> racers;
    public SortedMap<Duration, String> results;
    // ------------------
    private String abbr;
    private String name;
    private String team;

    public Racer() {
    }

    public Racer(String string) {
        abbr = string.substring(0, 3);
        String[] array = string.substring(4).split("_");
        name = array[0];
        team = array[1];
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
}
