package ua.com.foxminded.malzam.racers.service;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import ua.com.foxminded.malzam.racers.model.Racer;
import ua.com.foxminded.malzam.racers.service.formatter.ConsoleRacerFormatter;
import ua.com.foxminded.malzam.racers.service.formatter.RacerFormatter;

public class RacerReporter {
    
    private RacerFormatter racerFormat = new ConsoleRacerFormatter();
    
    private static final int DELIMITER_STRING = 15;
    private static final String SPLITTER = "-";
    private static final String EMPTY_LINE = "";
    private static final String NEW_LINE = "\n";
    private static final String PLACE_FORMATTER = "%2d.";
    
    public String buildReport(Set<Racer> racers) {
        int place = 1;
        StringBuilder builder = new StringBuilder();
        
        for (Racer racer : racers) {
            builder.append(String.format(PLACE_FORMATTER, place) + racerFormat.format(racer) + NEW_LINE);
            if (place == DELIMITER_STRING) {
                builder.append(StringUtils.leftPad(EMPTY_LINE, 59, SPLITTER) + NEW_LINE);
            }
            place++;
        }
        return builder.toString();
    }
}
