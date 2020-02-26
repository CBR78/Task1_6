package ua.com.foxminded.malzam.report_racers.runner;

import ua.com.foxminded.malzam.report_racers.service.RacerReader;

public class Runner {

    public static void main(String[] args) {
        String pathStartFile = "c:\\java\\files\\qualification1\\start.log";
        String pathEndFile = "c:\\java\\files\\qualification1\\end.log";
        String pathAbbrFile = "c:\\java\\files\\qualification1\\abbreviations.txt";

        RacerReader resultRacers = new RacerReader();
        
        String report = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        System.out.println(report);
        
        pathStartFile = "c:\\java\\files\\qualification2\\start.log";
        pathEndFile = "c:\\java\\files\\qualification2\\end.log";
        pathAbbrFile = "c:\\java\\files\\qualification2\\abbreviations.txt";

        report = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        System.out.println(report);
        
        pathStartFile = "c:\\java\\files\\qualification3\\start.log";
        pathEndFile = "c:\\java\\files\\qualification3\\end.log";
        pathAbbrFile = "c:\\java\\files\\qualification3\\abbreviations.txt";

        report = resultRacers.parseRacers(pathStartFile, pathEndFile, pathAbbrFile);
        System.out.println(report);
    }

}
