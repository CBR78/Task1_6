package ua.com.foxminded.malzam.racers.service.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.malzam.racers.model.LapTime;
import ua.com.foxminded.malzam.racers.model.Racer;

class ConsoleRacerFormatterTest {
    
    private static final String START_TIME = "2018-05-24T12:02:58.917";
    private static final String END_TIME   = "2018-05-24T12:04:03.332";
    private static final String NAME_RACER = "Sebastian Vettel";
    private static final String TEAM_RACER = "FERRARI";
    private static final String NAME_RACER_IS_EMPTY = "";
    private RacerFormatter racerFormat = new ConsoleRacerFormatter();
    
    @Test
    public void format_Expect_TargetString_IfRacer_IsSample() {
        Set<LapTime> resultTimeSVF = new HashSet<>();
        resultTimeSVF.add(new LapTime(
                LocalDateTime.parse(START_TIME),
                LocalDateTime.parse(END_TIME)));
        Racer racer = new Racer(NAME_RACER, TEAM_RACER, resultTimeSVF);
        String actual = racerFormat.format(racer);
        String expected = "Sebastian Vettel  | FERRARI                   | 1:04.415";
        assertEquals(expected, actual);
    }
    
    @Test
    public void format_Expect_TargetString_IfNameRacer_IsEmpty() {
        Set<LapTime> resultTimeSVF = new HashSet<>();
        resultTimeSVF.add(new LapTime(
                LocalDateTime.parse(START_TIME),
                LocalDateTime.parse(END_TIME)));
        Racer racer = new Racer(NAME_RACER_IS_EMPTY, TEAM_RACER, resultTimeSVF);
        String actual = racerFormat.format(racer);
        String expected = "                  | FERRARI                   | 1:04.415";
        assertEquals(expected, actual);
    }
}
