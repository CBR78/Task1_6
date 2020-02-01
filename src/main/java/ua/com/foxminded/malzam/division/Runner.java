package ua.com.foxminded.malzam.division;

public class Runner {

    public static void main(String[] args) {
        int exampleDividend = 78945;
        int exampleDivider = 4;
        
        int exampleDividend2 = 512;
        int exampleDivider2 = 8;
        
        Division division = new Division();
        System.out.println(division.integerDivision(exampleDividend, exampleDivider));
        System.out.println(division.integerDivision(exampleDividend2, exampleDivider2));
    }
}
