package ua.com.foxminded.malzam.report_racers.service;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import ua.com.foxminded.malzam.report_racers.model.LapTime;
import ua.com.foxminded.malzam.report_racers.model.Racer;

public class RacerReader {

    public Set<Racer> recieveRacers(String pathStartFile, String pathEndFile, String pathAbbrFile) {
        Set<Racer> racers = new TreeSet<>(Comparator.comparing(Racer::getBestLap));

        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(pathAbbrFile);

        try (Stream<String> streamRacersAbbr = Files
                .lines(Paths.get(new File(resource.getFile()).getPath()))) {
            streamRacersAbbr.forEach(line -> racers.add(new Racer(line.split("_")[0], line.split("_")[1],
                    line.split("_")[2], readLapTimes(pathStartFile, pathEndFile, line.split("_")[0]))));
        } catch (Exception ex) {

        }

        return racers;
    }

    private Set<LapTime> readLapTimes(String startPathFile, String endPathFile, String racerCode) {
        Set<LapTime> resultTime = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.S");
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(startPathFile);

        try (Stream<String> streamStartTime = Files
                .lines(Paths.get(new File(resource.getFile()).getPath()))) {
            streamStartTime.filter(l -> l.contains(racerCode)).forEach(l -> {
                try {
                    resultTime.add(new LapTime(LocalDateTime.parse(l.substring(3), formatter),
                            findEndTime(startPathFile, endPathFile, racerCode)));
                } catch (Exception ex) {

                }
            });
        } catch (Exception ex) {

        }
        return resultTime;
    }

    private LocalDateTime findEndTime(String startPathFile, String endPathFile, String racerCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.S");
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(endPathFile);

        try (Stream<String> streamEndTime = Files.lines(Paths.get(new File(resource.getFile()).getPath()))) {
            return LocalDateTime.parse(
                    streamEndTime.filter(l -> l.contains(racerCode)).findFirst().orElse("").substring(3),
                    formatter);
        } catch (Exception ex) {

        }
        return LocalDateTime.now();
    }
}
