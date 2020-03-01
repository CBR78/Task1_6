package ua.com.foxminded.malzam.racers.service.formatter;

import ua.com.foxminded.malzam.racers.model.Racer;

public class ConsoleRacerFormatter implements RacerFormatter {
    
    private static final String LINE_FORMAT = "%-17s | %-25s | %d:%tS.%tL";
    
    @Override
    public String format(Racer racer) {
        
        long timeLap = racer.getBestLap();
        long minute = timeLap / (60 * 1000);
        return String.format(LINE_FORMAT,
                racer.getName(),
                racer.getTeam(),
                minute, timeLap, timeLap);
    }
}
