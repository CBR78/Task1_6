package ua.com.foxminded.malzam.division;

public class Runner {

    public static void main(String[] args) {
        int exampleDividend = 78945;
        int exampleDivider = 4;
        
        Division division = new Division();
        System.out.println(division.makeDivision(exampleDividend, exampleDivider));
    }
}
