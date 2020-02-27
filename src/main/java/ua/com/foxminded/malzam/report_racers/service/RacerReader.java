package ua.com.foxminded.malzam.report_racers.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReader {
    private int numQualification = 0;
    private SortedSet<Racer> racers = new TreeSet<>((o1, o2) -> o1.getAbbr().compareTo(o2.getAbbr()));

    public Set<Racer> parseRacers(String pathStartFile, String pathEndFile, String pathAbbrFile) {
        numQualification++;

        try (Stream<String> streamRacers = Files.lines(Paths.get(pathAbbrFile));
                Stream<String> streamStart = Files.lines(Paths.get(pathStartFile));
                Stream<String> streamEnd = Files.lines(Paths.get(pathEndFile))) {

            racers = streamRacers.map(Racer::new).collect(Collectors.toCollection(() -> racers));

            Set<String> startResults = streamStart.collect(Collectors.toSet());
            for (String startTime : startResults) {
                String abbrResult = startTime.substring(0, 3);
                for (Racer racer : racers) {
                    String abbr = racer.getAbbr();
                    if (abbr.equals(abbrResult)) {
                        racer.setStartTime(numQualification, startTime);
                        break;
                    }
                }
            }

            Set<String> endResults = streamEnd.collect(Collectors.toSet());
            for (String endTime : endResults) {
                String abbrResult = endTime.substring(0, 3);
                for (Racer racer : racers) {
                    String abbr = racer.getAbbr();
                    if (abbr.equals(abbrResult)) {
                        racer.setEndTime(numQualification, endTime);
                        break;
                    }
                }
            }

        } catch (IOException ex) {

        }
        return racers;
    }
}
