package ua.com.foxminded.malzam.count.chars;

public class Runner {

    public static void main(String[] args) {
        String example = "hello world!";
        CharStatistics charStatistics = new CharStatistics();
        System.out.println(charStatistics.getCharStatistics(example));
    }

}
