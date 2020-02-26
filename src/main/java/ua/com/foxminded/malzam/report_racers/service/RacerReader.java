package ua.com.foxminded.malzam.report_racers.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReader {
    public Racer parseRacers(String pathStartFile, String pathEndFile, String pathAbbrFile) {

        Racer racers2 = new Racer();
        
        try (Stream<String> streamStart = Files.lines(Paths.get(pathStartFile));
                Stream<String> streamEnd = Files.lines(Paths.get(pathEndFile));
                Stream<String> streamRacers = Files.lines(Paths.get(pathAbbrFile))) {
        //--------------------------------------
            Map<String, String[]> racers = streamRacers
                    .collect(Collectors.toMap(p -> p.substring(0, 3), p -> p.substring(4).split("_")));
            
            racers2.racers = racers;
        //--------------------------------------    
            Map<String, LocalDateTime> startMap = streamStart
                    .collect(Collectors.toMap(p -> p.substring(0, 3),
                                              p -> LocalDateTime.parse(p.substring(3).replace("_", "T"))));
            Map<String, LocalDateTime> endMap = streamEnd
                    .collect(Collectors.toMap(p -> p.substring(0, 3),
                                              p -> LocalDateTime.parse(p.substring(3).replace("_", "T"))));
            SortedMap<Duration, String> results = countResults(startMap, endMap);
            racers2.results = results;
          //--------------------------------------    
        } catch (IOException ex) {

        }
        return racers2;
    }

    private SortedMap<Duration, String> countResults(Map<String, LocalDateTime> startMap,
                                                     Map<String, LocalDateTime> endMap) {
        SortedMap<Duration, String> resultsMap = new TreeMap<>();

        for (Map.Entry<String, LocalDateTime> mapEntry : startMap.entrySet()) {
            String abbrKey = mapEntry.getKey();
            Duration duration = Duration.between(startMap.get(abbrKey), endMap.get(abbrKey));
            resultsMap.put(duration, abbrKey);
        }
        return resultsMap;
    }
}
