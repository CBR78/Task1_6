package ua.com.foxminded.malzam.count.chars;

public class Runner {

    public static void main(String[] args) {
        String example = "hello world!";
        CountChars countChars = new CountChars();
        System.out.println(countChars.makeCountChars(example));
    }

}
