package ua.com.foxminded.malzam.report_racers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;

import ua.com.foxminded.malzam.report_racers.model.Racer;

class RacerReaderTest {

    String pathStartFile = "start.log";
    String pathEndFile = "end.log";
    String pathAbbrFile = "abbreviations.txt";
    String notExistFile = "";
    String emptyFile = "empty_file.txt";

    RacerReader resultRacers = new RacerReader();

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifAbbrFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(notExistFile, pathStartFile, pathEndFile));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifStartFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathAbbrFile, notExistFile, pathEndFile));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifEndFile_isNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathAbbrFile, pathStartFile, notExistFile));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifAbbrFile_isEmptyFile() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(emptyFile, pathStartFile, pathEndFile));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifStartFile_isEmptyFile() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathAbbrFile, emptyFile, pathEndFile));
    }

    @Test
    public void recieveRacers_Expect_IllegalArgumentException_ifEndFile_isEmptyFile() {
        assertThrows(IllegalArgumentException.class,
                () -> resultRacers.recieveRacers(pathAbbrFile, pathStartFile, emptyFile));
    }
    
    @Test
    public void recieveRacers_Expect_TragetText_IfFiles_IsSampleFiles() {
        Set<Racer> racers = resultRacers.recieveRacers(pathAbbrFile, pathStartFile, pathEndFile);
        RacerReporter racerReporter = new RacerReporter();
        String actual = racerReporter.buildReport(racers);
        String expected = 
                " 1. Sebastian Vettel  | FERRARI                   | 1:04.415\n" + 
                " 2. Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\n" + 
                " 3. Valtteri Bottas   | MERCEDES                  | 1:12.434\n" + 
                " 4. Lewis Hamilton    | MERCEDES                  | 1:12.460\n" + 
                " 5. Stoffel Vandoorne | MCLAREN RENAULT           | 1:12.463\n" + 
                " 6. Kimi Raikkonen    | FERRARI                   | 1:12.639\n" + 
                " 7. Fernando Alonso   | MCLAREN RENAULT           | 1:12.657\n" + 
                " 8. Sergey Sirotkin   | WILLIAMS MERCEDES         | 1:12.706\n" + 
                " 9. Charles Leclerc   | SAUBER FERRARI            | 1:12.829\n" + 
                "10. Sergio Perez      | FORCE INDIA MERCEDES      | 1:12.848\n" + 
                "11. Romain Grosjean   | HAAS FERRARI              | 1:12.930\n" + 
                "12. Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 1:12.941\n" + 
                "13. Carlos Sainz      | RENAULT                   | 1:12.950\n" + 
                "14. Esteban Ocon      | FORCE INDIA MERCEDES      | 1:13.028\n" + 
                "15. Nico Hulkenberg   | RENAULT                   | 1:13.065\n" + 
                "\r\n" + 
                "16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 1:13.179\n" + 
                "17. Marcus Ericsson   | SAUBER FERRARI            | 1:13.265\n" + 
                "18. Lance Stroll      | WILLIAMS MERCEDES         | 1:13.323\n" + 
                "19. Kevin Magnussen   | HAAS FERRARI              | 1:13.393\n" + 
                "";
        assertEquals(expected, actual);
    }
}
