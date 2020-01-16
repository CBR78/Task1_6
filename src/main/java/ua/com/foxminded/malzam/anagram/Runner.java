package ua.com.foxminded.malzam.anagram;

public class Runner {

    public static void main(String[] args) {
        String example = "a1bcd  efg!h";
        Anagram anagram = new Anagram();
        System.out.println(anagram.reverseText(example));
    }
}
