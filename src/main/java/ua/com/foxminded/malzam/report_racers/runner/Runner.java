package ua.com.foxminded.malzam.report_racers.runner;

import java.util.Set;

import ua.com.foxminded.malzam.report_racers.model.Racer;
import ua.com.foxminded.malzam.report_racers.service.RacerReader;
import ua.com.foxminded.malzam.report_racers.service.RacerReporter;

public class Runner {

    public static void main(String[] args) {
        String pathStartFile = "c:\\java\\files\\qualification1\\start.log";
        String pathEndFile = "c:\\java\\files\\qualification1\\end.log";
        String pathAbbrFile = "c:\\java\\files\\qualification1\\abbreviations.txt";

        RacerReader resultRacers = new RacerReader();
        RacerReporter racerReporter = new RacerReporter();

        Set<Racer> racers = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        String report = racerReporter.buildReport(racers);
        System.out.println(report);

        pathStartFile = "c:\\java\\files\\qualification2\\start.log";
        pathEndFile = "c:\\java\\files\\qualification2\\end.log";
        pathAbbrFile = "c:\\java\\files\\qualification2\\abbreviations.txt";

        racers = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        report = racerReporter.buildReport(racers);
        System.out.println(report);

        pathStartFile = "c:\\java\\files\\qualification3\\start.log";
        pathEndFile = "c:\\java\\files\\qualification3\\end.log";
        pathAbbrFile = "c:\\java\\files\\qualification3\\abbreviations.txt";

        racers = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        report = racerReporter.buildReport(racers);
        System.out.println(report);
    }

}
