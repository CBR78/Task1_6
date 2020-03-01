package ua.com.foxminded.malzam.racers.service;

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

import ua.com.foxminded.malzam.racers.model.LapTime;
import ua.com.foxminded.malzam.racers.model.Racer;

public class RacerReader {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final int RACER_CODE_LENGTH = 3;
    private static final String SPLITTER_SYMBOL = "_";
    
    public Set<Racer> recieveRacers(String pathAbbrFile, String pathStartFile, String pathEndFile) {
        
        validate(pathAbbrFile);
        validate(pathStartFile);
        validate(pathEndFile);

        Set<Racer> racers = new TreeSet<>(Comparator.comparing(Racer::getBestLap));
        ClassLoader loader = getClass().getClassLoader();
        URL urlAbbrFile = loader.getResource(pathAbbrFile);
        
        try (Stream<String> streamRacersAbbr
                = Files.lines(Paths.get(new File(urlAbbrFile.getFile()).getPath()))) {
            streamRacersAbbr.forEach(line -> racers.add(new Racer(
                    line.split(SPLITTER_SYMBOL)[1],
                    line.split(SPLITTER_SYMBOL)[2], 
                    readLapTimes(pathStartFile, pathEndFile, line.split(SPLITTER_SYMBOL)[0]))));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return racers;
    }
    
    public void validate(String pathFile) {
        ClassLoader loader = getClass().getClassLoader();
        URL urlAbbrFile = loader.getResource(pathFile);
        if (urlAbbrFile == null) {
            throw new IllegalArgumentException(
                    "File \"" + pathFile + "\" does not exist on the specified path");
        }
        
        File abbrFile = new File(urlAbbrFile.getFile());
        if (abbrFile.length() == 0) {
            throw new IllegalArgumentException(
                    "File \"" + pathFile + "\" is empty");
        }
    }

    private Set<LapTime> readLapTimes(String pathStartFile, String pathEndFile, String racerCode) {
        
        Set<LapTime> resultTime = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        ClassLoader loader = getClass().getClassLoader();
        URL urlStartFile = loader.getResource(pathStartFile);

        try (Stream<String> streamStartTime
                = Files.lines(Paths.get(new File(urlStartFile.getFile()).getPath()))) {
            streamStartTime.filter(l -> l.contains(racerCode)).forEach(l -> {
                resultTime.add(new LapTime(LocalDateTime.parse(
                        l.substring(RACER_CODE_LENGTH), formatter),
                        findEndTime(pathEndFile, racerCode)));
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return resultTime;
    }

    private LocalDateTime findEndTime(String pathEndFile, String racerCode) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        ClassLoader loader = getClass().getClassLoader();
        URL urlEndFile = loader.getResource(pathEndFile);

        try (Stream<String> streamEndTime
                = Files.lines(Paths.get(new File(urlEndFile.getFile()).getPath()))) {
            return LocalDateTime.parse(
                    streamEndTime.filter(l -> l.contains(racerCode)).findFirst().orElse("")
                    .substring(RACER_CODE_LENGTH),formatter);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return LocalDateTime.parse("");
    }
}
