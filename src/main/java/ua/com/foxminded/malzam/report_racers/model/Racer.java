package ua.com.foxminded.malzam.report_racers.model;

import java.time.Duration;
import java.util.Comparator;
import java.util.Set;

public class Racer {
    private String abbr;
    private String name;
    private String team;
    private Set<LapTime> lapTimeSet;

    public Racer(String abbr, String name, String team, Set<LapTime> lapTimeSet) {
        super();
        this.abbr = abbr;
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

    public Duration getBestLap() {
        return lapTimeSet.stream().sorted(Comparator.comparing(LapTime::getDuration))
                .map(LapTime::getDuration).findFirst().orElse(Duration.ZERO);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((abbr == null) ? 0 : abbr.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((team == null) ? 0 : team.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Racer other = (Racer) obj;
        if (abbr == null) {
            if (other.abbr != null)
                return false;
        } else if (!abbr.equals(other.abbr))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (team == null) {
            if (other.team != null)
                return false;
        } else if (!team.equals(other.team))
            return false;
        return true;
    }
    
    
}
