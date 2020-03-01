package ua.com.foxminded.malzam.racers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.malzam.racers.model.LapTime;
import ua.com.foxminded.malzam.racers.model.Racer;

class RacerReaderTest {

    private static final String NOT_EXIST_FILE = "NOT_EXIST_FILE";
    private static final String EMPTY_FILE = "empty_file.txt";
    private static final String ABBR_FILE  = "abbreviations_test_two_line.txt";
    private static final String START_FILE = "start_test_two_line.log";
    private static final String END_FILE   = "end_test_two_line.log";
    private RacerReader reader = new RacerReader();

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifAbbrFile_isNotExist() {
        assertThrows(IllegalArgumentException.class, () -> reader.validate(NOT_EXIST_FILE));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifAbbrFile_isEmptyFile() {
        assertThrows(IllegalArgumentException.class, () -> reader.validate(EMPTY_FILE));
    }

    @Test
    public void recieveRacers_Expect_TargetSet_IfFiles_IsSampleFiles() {
        Set<Racer> actualRacers = reader.recieveRacers(ABBR_FILE, START_FILE, END_FILE);
        Set<Racer> expectedRacers = new TreeSet<>(Comparator.comparing(Racer::getBestLap));
        Set<LapTime> resultTimeSVF = new HashSet<>();
        resultTimeSVF.add(new LapTime(
                LocalDateTime.parse("2018-05-24T12:02:58.917"),
                LocalDateTime.parse("2018-05-24T12:04:03.332")));
        Set<LapTime> resultTimeDRR = new HashSet<>();
        resultTimeDRR.add(new LapTime(
                LocalDateTime.parse("2018-05-24T12:14:12.054"),
                LocalDateTime.parse("2018-05-24T12:15:24.067")));
        expectedRacers.add(new Racer("Sebastian Vettel", "FERRARI", resultTimeSVF));
        expectedRacers.add(new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", resultTimeDRR));
        assertEquals(expectedRacers, actualRacers);
    }
}
