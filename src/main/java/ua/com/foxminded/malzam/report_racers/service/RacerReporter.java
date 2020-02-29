package ua.com.foxminded.malzam.report_racers.service;

import java.util.Set;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReporter {

    public String buildReport(Set<Racer> racers) {
        final int DELIMITER_STRING = 15;
        int place = 0;
        StringBuilder builder = new StringBuilder();
        
        for (Racer racer : racers) {
            place++;
            String name = racer.getName();
            String team = racer.getTeam();
            long timeLap = racer.getBestLap();
            long minute = timeLap / (60 * 1000);
            builder.append(String.format("%2d. %-17s | %-25s | %d:%tS.%tL",
                                         place, name, team, minute, timeLap, timeLap) + "\n");
            if (place == DELIMITER_STRING) {
                builder.append(String.format("%n"));
            }
        }
        return builder.toString();
    }
}
