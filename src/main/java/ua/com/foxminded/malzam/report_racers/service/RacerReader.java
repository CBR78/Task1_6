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

    public Set<Racer> recieveRacers(String pathAbbrFile, String pathStartFile, String pathEndFile) {

        Set<Racer> racers = new TreeSet<>(Comparator.comparing(Racer::getBestLap));
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(pathAbbrFile);

        try (Stream<String> streamRacersAbbr = Files.lines(Paths.get(new File(resource.getFile()).getPath()))) {
            streamRacersAbbr.forEach(line -> racers.add(new Racer(
                    line.split("_")[1],
                    line.split("_")[2], 
                    readLapTimes(pathStartFile, pathEndFile, line.split("_")[0]))));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return racers;
    }

    private Set<LapTime> readLapTimes(String pathStartFile, String pathEndFile, String racerCode) {
        
        Set<LapTime> resultTime = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(pathStartFile);

        try (Stream<String> streamStartTime = Files.lines(Paths.get(new File(resource.getFile()).getPath()))) {
            streamStartTime.filter(l -> l.contains(racerCode)).forEach(l -> {
                resultTime.add(new LapTime(LocalDateTime.parse(
                        l.substring(3), formatter),
                        findEndTime(pathEndFile, racerCode)));
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resultTime;
    }

    private LocalDateTime findEndTime(String pathEndFile, String racerCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(pathEndFile);

        try (Stream<String> streamEndTime = Files.lines(Paths.get(new File(resource.getFile()).getPath()))) {
            return LocalDateTime.parse(
                    streamEndTime.filter(l -> l.contains(racerCode)).findFirst().orElse("").substring(3),
                    formatter);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return LocalDateTime.now();
    }
}
