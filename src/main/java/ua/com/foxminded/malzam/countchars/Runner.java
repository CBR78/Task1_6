package ua.com.foxminded.malzam.countchars;

public class Runner {

    public static void main(String[] args) {
        String example = "hello world!";
        CharCounter charCounter = new CharCounter();
        System.out.println(charCounter.countChars(example));
    }

}
