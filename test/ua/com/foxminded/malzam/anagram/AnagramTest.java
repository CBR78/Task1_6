package ua.com.foxminded.malzam.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    public void reverseText_Expect_ThrowNullPointerException_IfInput_Null() {
        assertThrows(NullPointerException.class, () -> anagram.reverseText(null));
    }

    @Test
    public void reverseText_Expect_EmptyString_IfInput_Empty() {
        assertEquals("", anagram.reverseText(""));
    }

    @Test
    public void reverseText_Expect_EmptyString_IfInput_OneSpace() {
        assertEquals("", anagram.reverseText(" "));
    }

    @Test
    public void reverseText_Expect_EmptyString_IfInput_TwoSpaces() {
        assertEquals("", anagram.reverseText("  "));
    }

    @Test
    public void reverseText_Expect_ReversedTwoLettersInUpperCase_IfInput_TwoLettersInUpperCase() {
        assertEquals("BA", anagram.reverseText("AB"));
    }

    @Test
    public void reverseText_Expect_ReversedTwoLettersInLowerCase_IfInput_TwoLettersInLowerCase() {
        assertEquals("ba", anagram.reverseText("ab"));
    }

    @Test
    public void reverseText_Expect_ThreeSymbols_IfInput_ThreeSymbols() {
        assertEquals("@#$", anagram.reverseText("@#$"));
    }

    @Test
    public void reverseText_Expect_ThreeNumbers_IfInput_ThreeNumbers() {
        assertEquals("582", anagram.reverseText("582"));
    }

    @Test
    public void reverseText_Expect_ReversedThreeLettersInDifferentCase_IfInput_ThreeLettersInDifferentCase() {
        assertEquals("Cba", anagram.reverseText("abC"));
    }

    @Test
    public void reverseText_Expect_TwoWordsFromSymbols_IfInput_TwoWordsFromSymbols() {
        assertEquals("-+/* @#$%", anagram.reverseText("-+/* @#$%"));
    }

    @Test
    public void reverseText_Expect_TwoWordsFromNumbers_IfInput_TwoWordsFromNumbers() {
        assertEquals("12345 67890", anagram.reverseText("12345 67890"));
    }

    @Test
    public void reverseText_Expect_ReversedTwoWordsFromLetters_IfInput_TwoWordsFromLetters() {
        assertEquals("gfEDcba KjYHF", anagram.reverseText("abcDEfg FHYjK"));
    }

}
