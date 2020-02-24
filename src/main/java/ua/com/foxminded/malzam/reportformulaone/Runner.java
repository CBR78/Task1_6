package ua.com.foxminded.malzam.reportformulaone;

public class Runner {

    public static void main(String[] args) {

        String pathStartFile = "c:\\java\\files\\start.log";
        String pathEndFile = "c:\\java\\files\\end.log";
        String pathAbbrFile = "c:\\java\\files\\abbreviations.txt";

        ReportFormulaOne reportFormulaOne = new ReportFormulaOne();
        String report = reportFormulaOne.makeReportFormulaOne(pathStartFile, pathEndFile, pathAbbrFile);
        System.out.println(report);
    }
}
