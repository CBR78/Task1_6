package ua.com.foxminded.malzam.report_racers.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RacerReaderTest {

    String pathStartFile = "c:\\java\\files\\qualification1\\start.log";
    String pathEndFile   = "c:\\java\\files\\qualification1\\end.log";
    String pathAbbrFile  = "c:\\java\\files\\qualification1\\abbreviations.txt";
    String notExistFile  = "c:\\";

    RacerReader resultRacers = new RacerReader();

    @Test
    public void parseFiles_Expect_IllegalArgumentException_ifStartFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(notExistFile, pathEndFile, pathAbbrFile));
    }

    @Test
    public void parseFiles_Expect_IllegalArgumentException_ifEndFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathStartFile, notExistFile, pathAbbrFile));
    }

    @Test
    public void parseFiles_Expect_IllegalArgumentException_ifAbbrFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathStartFile, pathEndFile, notExistFile));
    }
}
