package ua.com.foxminded.malzam.report_racers.first_iteration;

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

public class ReportFormulaOne {

    public String makeReportFormulaOne(String pathStartFile, String pathEndFile, String pathAbbrFile) {

        String report = "";

        try (Stream<String> streamStart = Files.lines(Paths.get(pathStartFile));
                Stream<String> streamEnd = Files.lines(Paths.get(pathEndFile));
                Stream<String> streamRacers = Files.lines(Paths.get(pathAbbrFile))) {

            Map<String, String[]> racers = streamRacers
                    .collect(Collectors.toMap(p -> p.substring(0, 3), p -> p.substring(4).split("_")));
            Map<String, LocalDateTime> startMap = streamStart
                    .collect(Collectors.toMap(p -> p.substring(0, 3),
                                              p -> LocalDateTime.parse(p.substring(3).replace("_", "T"))));
            Map<String, LocalDateTime> endMap = streamEnd
                    .collect(Collectors.toMap(p -> p.substring(0, 3),
                                              p -> LocalDateTime.parse(p.substring(3).replace("_", "T"))));
            SortedMap<Duration, String> results = countResults(startMap, endMap);
            report = buildReport(results, racers);

        } catch (IOException ex) {

        }
        return report;
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

    private String buildReport(SortedMap<Duration, String> results, Map<String, String[]> racers) {
        int place = 0;
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Duration, String> resultsMapEntry : results.entrySet()) {
            Duration timeLap = resultsMapEntry.getKey();
            String abbrKey = resultsMapEntry.getValue();
            place++;
            String racer = racers.get(abbrKey)[0];
            String team = racers.get(abbrKey)[1];
            long minute = timeLap.toMinutes();
            long second = timeLap.getSeconds() % 60;
            long milli = timeLap.getNano() / 1000000;
            builder.append(String.format("%2d. %-17s | %-25s | %d:%02d.%tL",
                                         place, racer, team, minute, second, milli) + "\n");
            if (place == 15) {
                builder.append(String.format("%n"));
            }
        }
        return builder.toString();
    }
}
