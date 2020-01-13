package ua.com.foxminded.malzam.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramTest {

    Anagram anagram = new Anagram();

    @Test
    public void reverseText_Expect_IllegalArgumentException_IfText_IsNull() {
        assertThrows(IllegalArgumentException.class, () -> anagram.reverseText(null));
    }

    @Test
    public void reverseText_Expect_IllegalArgumentException_IfText_IsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> anagram.reverseText(""));
    }

    @Test
    public void reverseText_Expect_EmptyString_IfText_IsOneSpace() {
        assertEquals("", anagram.reverseText(" "));
    }

    @Test
    public void reverseText_Expect_EmptyString_IfText_IsTwoSpaces() {
        assertEquals("", anagram.reverseText("  "));
    }

    @Test
    public void reverseText_Expect_ReversedTwoLettersInUpperCase_IfText_IsTwoLettersInUpperCase() {
        assertEquals("BA", anagram.reverseText("AB"));
    }

    @Test
    public void reverseText_Expect_ReversedTwoLettersInLowerCase_IfText_IsTwoLettersInLowerCase() {
        assertEquals("ba", anagram.reverseText("ab"));
    }

    @Test
    public void reverseText_Expect_ThreeSymbols_IfText_IsThreeSymbols() {
        assertEquals("@#$", anagram.reverseText("@#$"));
    }

    @Test
    public void reverseText_Expect_ThreeNumbers_IfText_IsThreeNumbers() {
        assertEquals("582", anagram.reverseText("582"));
    }

    @Test
    public void reverseText_Expect_ReversedThreeLettersInDifferentCase_IfText_IsThreeLettersInDifferentCase() {
        assertEquals("Cba", anagram.reverseText("abC"));
    }

    @Test
    public void reverseText_Expect_TwoWordsFromSymbols_IfText_IsTwoWordsFromSymbols() {
        assertEquals("-+/* @#$%", anagram.reverseText("-+/* @#$%"));
    }

    @Test
    public void reverseText_Expect_TwoWordsFromNumbers_IfText_IsTwoWordsFromNumbers() {
        assertEquals("12345 67890", anagram.reverseText("12345 67890"));
    }

    @Test
    public void reverseText_Expect_ReversedTwoWordsFromLetters_IfText_IsTwoWordsFromLetters() {
        assertEquals("gfEDcba KjYHF", anagram.reverseText("abcDEfg FHYjK"));
    }

}
