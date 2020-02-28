package ua.com.foxminded.malzam.report_racers.service;

import java.time.Duration;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReporter {

    public String buildReport(Set<Racer> racers) {
        final int DELIMITER_STRING = 15;
        int place = 0;
        StringBuilder builder = new StringBuilder();
        SortedSet<Racer> sortedRacers = new TreeSet<>((o1, o2) -> o1.getBestLap().compareTo(o2.getBestLap()));
        sortedRacers.addAll(racers);

        for (Racer racer : sortedRacers) {
            place++;
            String name = racer.getName();
            String team = racer.getTeam();
            Duration timeLap = racer.getBestLap();
            long minute = timeLap.toMinutes();
            long second = timeLap.getSeconds() % 60;
            long milli = timeLap.getNano() / 1000000;
            builder.append(String.format("%2d. %-17s | %-25s | %d:%02d.%tL",
                                         place, name, team, minute, second, milli) + "\n");
            if (place == DELIMITER_STRING) {
                builder.append(String.format("%n"));
            }
        }
        return builder.toString();
    }
}
