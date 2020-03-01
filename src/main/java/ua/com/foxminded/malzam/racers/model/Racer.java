package ua.com.foxminded.malzam.racers.model;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Racer {
    private final String name;
    private final String team;
    private final Set<LapTime> lapTimeSet;

    public Racer(String name, String team, Set<LapTime> lapTimeSet) {
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

    @Override
    public int hashCode() {
        return Objects.hash(name, team);
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
        return Objects.equals(name, other.name) && Objects.equals(team, other.team);
    }

    @Override
    public String toString() {
        return "Racer [name=" + name + ", team=" + team + ", lapTimeSet=" + lapTimeSet + "]";
    }
}
