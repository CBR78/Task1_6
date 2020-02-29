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
        
        validate(pathAbbrFile, pathStartFile, pathEndFile);

        Set<Racer> racers = new TreeSet<>(Comparator.comparing(Racer::getBestLap));
        ClassLoader loader = getClass().getClassLoader();
        URL urlAbbrFile = loader.getResource(pathAbbrFile);
        
        try (Stream<String> streamRacersAbbr
                = Files.lines(Paths.get(new File(urlAbbrFile.getFile()).getPath()))) {
            streamRacersAbbr.forEach(line -> racers.add(new Racer(
                    line.split("_")[1],
                    line.split("_")[2], 
                    readLapTimes(pathStartFile, pathEndFile, line.split("_")[0]))));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return racers;
    }
    
    private void validate(String pathAbbrFile, String pathStartFile, String pathEndFile) {
        ClassLoader loader = getClass().getClassLoader();
        
        URL urlAbbrFile = loader.getResource(pathAbbrFile);
        if (urlAbbrFile == null) {
            throw new IllegalArgumentException(
                    "File \"" + pathAbbrFile + "\" does not exist on the specified path");
        }
        
        URL urlStartFile = loader.getResource(pathStartFile);
        if (urlStartFile == null) {
            throw new IllegalArgumentException(
                    "File \"" + pathStartFile + "\" does not exist on the specified path");
        }
        
        URL urlEndFile = loader.getResource(pathEndFile);
        if (urlEndFile == null) {
            throw new IllegalArgumentException(
                    "File \"" + pathEndFile + "\" does not exist on the specified path");
        }
        
        File abbrFile = new File(urlAbbrFile.getFile());
        if (abbrFile.length() == 0) {
            throw new IllegalArgumentException("File \"" + pathAbbrFile + "\" is empty");
        }
        
        File startFile = new File(urlStartFile.getFile());
        if (startFile.length() == 0) {
            throw new IllegalArgumentException("File \"" + pathStartFile + "\" is empty");
        }
        
        File endFile = new File(urlEndFile.getFile());
        if (endFile.length() == 0) {
            throw new IllegalArgumentException("File \"" + pathEndFile + "\" is empty");
        }
    }

    private Set<LapTime> readLapTimes(String pathStartFile, String pathEndFile, String racerCode) {
        
        Set<LapTime> resultTime = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        ClassLoader loader = getClass().getClassLoader();
        URL urlStartFile = loader.getResource(pathStartFile);

        try (Stream<String> streamStartTime
                = Files.lines(Paths.get(new File(urlStartFile.getFile()).getPath()))) {
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
        URL urlEndFile = loader.getResource(pathEndFile);

        try (Stream<String> streamEndTime
                = Files.lines(Paths.get(new File(urlEndFile.getFile()).getPath()))) {
            return LocalDateTime.parse(
                    streamEndTime.filter(l -> l.contains(racerCode)).findFirst().orElse("")
                    .substring(3),formatter);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return LocalDateTime.parse("");
    }
}
