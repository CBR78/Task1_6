package ua.com.foxminded.malzam.report_racers.runner;

import java.util.Set;

import ua.com.foxminded.malzam.report_racers.model.Racer;
import ua.com.foxminded.malzam.report_racers.service.RacerReader;
import ua.com.foxminded.malzam.report_racers.service.RacerReporter;

public class Runner {

    public static void main(String[] args) {
        
        RacerReader resultRacers = new RacerReader();
        RacerReporter racerReporter = new RacerReporter();

        String pathStartFile = "start.log";
        String pathEndFile = "end.log";
        String pathAbbrFile = "abbreviations.txt";

        Set<Racer> racers = resultRacers.recieveRacers(pathStartFile, pathEndFile, pathAbbrFile);
        String report = racerReporter.buildReport(racers);
        System.out.println(report);
        
    
}}
