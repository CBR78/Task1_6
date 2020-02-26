package ua.com.foxminded.malzam.report_racers.first_iteration;

public class Runner {

    public static void main(String[] args) {

        String pathStartFile = "c:\\java\\files\\qualification1\\start.log";
        String pathEndFile = "c:\\java\\files\\qualification1\\end.log";
        String pathAbbrFile = "c:\\java\\files\\qualification1\\abbreviations.txt";

        ReportFormulaOne reportFormulaOne = new ReportFormulaOne();
        String report = reportFormulaOne.makeReportFormulaOne(pathStartFile, pathEndFile, pathAbbrFile);
        System.out.println(report);
    }
}
