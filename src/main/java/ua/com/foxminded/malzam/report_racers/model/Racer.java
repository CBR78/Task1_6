package ua.com.foxminded.malzam.report_racers.model;

import java.util.Comparator;
import java.util.Set;

public class Racer {
    private String name;
    private String team;
    private Set<LapTime> lapTimeSet;

    public Racer(String name, String team, Set<LapTime> lapTimeSet) {
        super();
        this.name = name;
        this.team = team;
        this.lapTimeSet = lapTimeSet;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public long getBestLap() {
        return lapTimeSet.stream().sorted(Comparator.comparing(LapTime::getDuration))
                .map(LapTime::getDuration).findFirst().orElse(0L);
    }
}
