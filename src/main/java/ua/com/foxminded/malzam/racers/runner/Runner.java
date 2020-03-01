package ua.com.foxminded.malzam.racers.runner;

import java.util.Set;

import ua.com.foxminded.malzam.racers.model.Racer;
import ua.com.foxminded.malzam.racers.service.RacerReader;
import ua.com.foxminded.malzam.racers.service.RacerReporter;

public class Runner {

    public static void main(String[] args) {

        RacerReader resultRacers = new RacerReader();
        RacerReporter racerReporter = new RacerReporter();

        String pathAbbrFile  = "abbreviations.txt";
        String pathStartFile = "start.log";
        String pathEndFile   = "end.log";

        Set<Racer> racers = resultRacers.recieveRacers(pathAbbrFile, pathStartFile, pathEndFile);
        String report = racerReporter.buildReport(racers);
        System.out.println(report);
    }
}
