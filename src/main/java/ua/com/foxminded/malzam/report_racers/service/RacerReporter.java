package ua.com.foxminded.malzam.report_racers.service;

import java.time.Duration;
import java.util.Map;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReporter {
    
    public String buildReport(Racer racers) {
        int place = 0;
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Duration, String> resultsMapEntry : racers.results.entrySet()) {
            Duration timeLap = resultsMapEntry.getKey();
            String abbrKey = resultsMapEntry.getValue();
            place++;
            String racer = racers.racers.get(abbrKey)[0];
            String team = racers.racers.get(abbrKey)[1];
            long minute = timeLap.toMinutes();
            long second = timeLap.getSeconds() % 60;
            long milli = timeLap.getNano() / 1000000;
            builder.append(String.format("%2d. %-17s | %-25s | %d:%02d.%tL",
                                         place, racer, team, minute, second, milli) + "\n");
            if (place == 15) {
                builder.append(String.format("%n"));
            }
        }
        return builder.toString();
    }
}
