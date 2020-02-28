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
    private SortedSet<Racer> racersSet = new TreeSet<>((o1, o2) -> o1.getAbbr().compareTo(o2.getAbbr()));

    public Set<Racer> parseFiles(String pathStartFile, String pathEndFile, String pathAbbrFile) {

        try (Stream<String> streamRacers = Files.lines(Paths.get(pathAbbrFile));
                Stream<String> streamStart = Files.lines(Paths.get(pathStartFile));
                Stream<String> streamEnd = Files.lines(Paths.get(pathEndFile))) {

            //racers = streamRacers.map(Racer::new).collect(Collectors.toCollection(() -> racers));
            
            Set<String> racersString = streamRacers.collect(Collectors.toSet());
            
            for (String racerString : racersString) {
                String abbr = racerString.substring(0, 3);
                String[] array = racerString.substring(4).split("_");
                String name = array[0];
                String team = array[1];
                Racer racer = new Racer(abbr, name, team);
                racersSet.add(racer);
            }
            
            
            
            Set<String> startResults = streamStart.collect(Collectors.toSet());

            for (Racer racer : racersSet) {
                String abbrRacer = racer.getAbbr();

                for (String startTime : startResults) {
                    String abbrStart = startTime.substring(0, 3);
                    if (abbrStart.equals(abbrRacer)) {
                        racer.setStartTime(startTime);
                        break;
                    }
                }
            }

            Set<String> endResults = streamEnd.collect(Collectors.toSet());

            for (Racer racer : racersSet) {
                String abbrRacer = racer.getAbbr();

                for (String endTime : endResults) {
                    String abbrEnd = endTime.substring(0, 3);
                    if (abbrEnd.equals(abbrRacer)) {
                        racer.setEndTime(endTime);
                        break;
                    }
                }
            }

        } catch (IOException ex) {

        }
        return racersSet;
    }
}
