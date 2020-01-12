package ua.com.foxminded.malzam.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    public void reverseTextShouldReturnStringWithReversedThreeWordsFromLettersNumbersAndSymbolsIfInputTextThreeWordsFromLettersNumbersAndSymbols() {
        assertEquals("g1f2-E34+56D/c*ba3 4K7@89j#Y0$H%F P^O&n(m)l_",
                anagram.reverseText("a1b2-c34+56D/E*fg3 4F7@89H#Y0$j%K l^m&n(O)P_"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedThreeWordsFromLettersIfInputTextThreeWordsFromLetters() {
        assertEquals("FgfEDcba lKjYH POnm", anagram.reverseText("abcDEfgF HYjKl mnOP"));
    }

    @Test
    public void reverseTextShouldReturnStringWithThreeWordsFromNumbersIfInputTextThreeWordsFromNumbers() {
        assertEquals("123 456 7890", anagram.reverseText("123 456 7890"));
    }

    @Test
    public void reverseTextShouldReturnStringWithThreeWordsFromSymbolsIfInputTextThreeWordsFromSymbols() {
        assertEquals("-+/* @#$% ^&()_", anagram.reverseText("-+/* @#$% ^&()_"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedTwoWordsFromLettersIfInputTextTwoWordsFromLetters() {
        assertEquals("gfEDcba KjYHF", anagram.reverseText("abcDEfg FHYjK"));
    }

    @Test
    public void reverseTextShouldReturnStringWithTwoWordsFromNumbersIfInputTextTwoWordsFromNumbers() {
        assertEquals("12345 67890", anagram.reverseText("12345 67890"));
    }

    @Test
    public void reverseTextShouldReturnStringWithTwoWordsFromSymbolsIfInputTextTwoWordsFromSymbols() {
        assertEquals("-+/* @#$%", anagram.reverseText("-+/* @#$%"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedThreeLettersInLowerCaseIfInputTextThreeLettersInLowerCase() {
        assertEquals("cba", anagram.reverseText("abc"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedThreeLettersInUpperCaseIfInputTextThreeLettersInUpperCase() {
        assertEquals("CBA", anagram.reverseText("ABC"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedThreeLettersInDifferentCaseIfInputTextThreeLettersInDifferentCase() {
        assertEquals("Cba", anagram.reverseText("abC"));
    }

    @Test
    public void reverseTextShouldReturnStringWithThreeNumbersIfInputTextThreeNumbers() {
        assertEquals("582", anagram.reverseText("582"));
    }

    @Test
    public void reverseTextShouldReturnStringWithThreeSymbolsIfInputTextThreeSymbols() {
        assertEquals("@#$", anagram.reverseText("@#$"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedTwoLettersInLowerCaseIfInputTextTwoLettersInLowerCase() {
        assertEquals("ba", anagram.reverseText("ab"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedTwoLettersInUpperCaseIfInputTextTwoLettersInUpperCase() {
        assertEquals("BA", anagram.reverseText("AB"));
    }

    @Test
    public void reverseTextShouldReturnStringWithReversedTwoLettersInDifferentCaseIfInputTextTwoLettersInDifferentCase() {
        assertEquals("Ba", anagram.reverseText("aB"));
    }

    @Test // ------------------
    public void reverseTextShouldReturnStringWithTwoNumbersIfInputTextTwoNumbers() {
        assertEquals("56", anagram.reverseText("56"));
    }

    @Test
    public void reverseTextShouldReturnStringWithTwoSymbolsIfInputTextTwoSymbols() {
        assertEquals("#$", anagram.reverseText("#$"));
    }

    @Test
    public void reverseTextShouldReturnStringWithOneLetterInLowerCaseIfInputTextOneLetterInLowerCase() {
        assertEquals("a", anagram.reverseText("a"));
    }

    @Test
    public void reverseTextShouldReturnStringWithOneLetterInUpperCaseIfInputTextOneLetterInUpperCase() {
        assertEquals("A", anagram.reverseText("A"));
    }

    @Test
    public void reverseTextShouldReturnStringWithOneNumberIfInputTextOneNumber() {
        assertEquals("5", anagram.reverseText("5"));
    }

    @Test
    public void reverseTextShouldReturnStringWithOneSymbolIfInputTextOneSymbol() {
        assertEquals("#", anagram.reverseText("#"));
    }

    @Test
    public void reverseTextShouldReturnEmptyStringIfInputTextThreeSpaces() {
        assertEquals("", anagram.reverseText("   "));
    }

    @Test
    public void reverseTextShouldReturnEmptyStringIfInputTextTwoSpaces() {
        assertEquals("", anagram.reverseText("  "));
    }

    @Test
    public void reverseTextShouldReturnEmptyStringIfInputTextOneSpace() {
        assertEquals("", anagram.reverseText(" "));
    }

    @Test
    public void reverseTextShouldReturnEmptyStringIfInputTextIsEmpty() {
        assertEquals("", anagram.reverseText(""));
    }

    @Test
    public void reverseTextShouldThrowNullPointerExceptionIfInputTextIsNull() {
        assertThrows(NullPointerException.class, () -> anagram.reverseText(null));
    }

}
