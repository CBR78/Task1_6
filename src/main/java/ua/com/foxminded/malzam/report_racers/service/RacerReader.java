package ua.com.foxminded.malzam.report_racers.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReader {
    private Set<Racer> racers = new HashSet<>();

    public Set<Racer> parseFiles(String pathStartFile, String pathEndFile, String pathAbbrFile) {

        try (Stream<String> streamRacers = Files.lines(Paths.get(pathAbbrFile));
                Stream<String> streamStart = Files.lines(Paths.get(pathStartFile));
                Stream<String> streamEnd = Files.lines(Paths.get(pathEndFile))) {

            Set<String> racersString = streamRacers.collect(Collectors.toSet());
            parseRacersString(racersString);
            Set<String> startResults = streamStart.collect(Collectors.toSet());
            parseStartResults(startResults);
            Set<String> endResults = streamEnd.collect(Collectors.toSet());
            parseEndResults(endResults);

        } catch (IOException ex) {

        }
        return racers;
    }

    private void parseRacersString(Set<String> racersString) {
        for (String racerString : racersString) {
            String abbr = racerString.substring(0, 3);
            String[] array = racerString.substring(4).split("_");
            String name = array[0];
            String team = array[1];
            Racer racer = new Racer(abbr, name, team);
            racers.add(racer);
        }
    }

    private void parseStartResults(Set<String> startResults) {
        for (Racer racer : racers) {
            String abbrRacer = racer.getAbbr();

            for (String startTime : startResults) {
                String abbrStart = startTime.substring(0, 3);
                if (abbrStart.equals(abbrRacer)) {
                    LocalDateTime startLDT = LocalDateTime.parse(startTime.substring(3).replace("_", "T"));
                    racer.setStartTime(startLDT);
                    break;
                }
            }
        }
    }

    private void parseEndResults(Set<String> endResults) {
        for (Racer racer : racers) {
            String abbrRacer = racer.getAbbr();

            for (String endTime : endResults) {
                String abbrEnd = endTime.substring(0, 3);
                if (abbrEnd.equals(abbrRacer)) {
                    LocalDateTime endLDT = LocalDateTime.parse(endTime.substring(3).replace("_", "T"));
                    racer.setEndTime(endLDT);
                    break;
                }
            }
        }
    }
}
