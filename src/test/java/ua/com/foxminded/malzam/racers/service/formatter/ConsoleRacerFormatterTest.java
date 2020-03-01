package ua.com.foxminded.malzam.racers.service.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.malzam.racers.model.LapTime;
import ua.com.foxminded.malzam.racers.model.Racer;

class ConsoleRacerFormatterTest {
    
    private static final String STARTTIME = "2018-05-24T12:02:58.917";
    private static final String ENDTIME = "2018-05-24T12:04:03.332";
    private static final String NAMERACER = "Sebastian Vettel";
    private static final String TEAMRACER = "FERRARI";
    private RacerFormatter racerFormat = new ConsoleRacerFormatter();
    
    @Test
    public void format_Expect_TragetString_IfRacer_IsSample() {
        Set<LapTime> resultTimeSVF = new HashSet<>();
        resultTimeSVF.add(new LapTime(
                LocalDateTime.parse(STARTTIME),
                LocalDateTime.parse(ENDTIME)));
        Racer racer = new Racer(NAMERACER, TEAMRACER, resultTimeSVF);
        String actual = racerFormat.format(racer);
        String expected = "Sebastian Vettel  | FERRARI                   | 1:04.415";
        assertEquals(expected, actual);
    }
}
