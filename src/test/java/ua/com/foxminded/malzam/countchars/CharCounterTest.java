package ua.com.foxminded.malzam.countchars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CharCounterTest {

    private CharCounter charCounter = new CharCounter();

    @Test
    public void charCounter_Expect_IllegalArgumentException_IfText_IsNull() {
        assertThrows(IllegalArgumentException.class, () -> charCounter.countChars(null));
    }

    @Test
    public void charCounter_Expect_IllegalArgumentException_IfText_IsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> charCounter.countChars(""));
    }

    @Test
    public void charCounter_Expect_IfText_IsHelloWorld() {
        String actual = charCounter.countChars("hello world!");
        String expected = "hello world!\n"
                        + "\"h\" - 1\n"
                        + "\"e\" - 1\n" 
                        + "\"l\" - 3\n" 
                        + "\"o\" - 2\n" 
                        + "\" \" - 1\n" 
                        + "\"w\" - 1\n" 
                        + "\"r\" - 1\n" 
                        + "\"d\" - 1\n" 
                        + "\"!\" - 1";
        assertEquals(expected, actual);
    }

    @Test
    public void charCounter_Expect_IfText_IsHelloWorldAndDigit() {
        String actual = charCounter.countChars("he8826llo worl87d!");
        String expected = "he8826llo worl87d!\n" 
                        + "\"h\" - 1\n" 
                        + "\"e\" - 1\n" 
                        + "\"8\" - 3\n" 
                        + "\"2\" - 1\n" 
                        + "\"6\" - 1\n" 
                        + "\"l\" - 3\n" 
                        + "\"o\" - 2\n" 
                        + "\" \" - 1\n" 
                        + "\"w\" - 1\n" 
                        + "\"r\" - 1\n" 
                        + "\"7\" - 1\n" 
                        + "\"d\" - 1\n" 
                        + "\"!\" - 1"; 
        assertEquals(expected, actual);
    }
    
    @Test
    public void cachedResponse_Expect_IfText_IsTestCache() {
        charCounter.countChars("test cache");
        String actual = charCounter.getTextCache().get("test cache");
        String expected = "test cache\n" 
                        + "\"t\" - 2\n" 
                        + "\"e\" - 2\n" 
                        + "\"s\" - 1\n" 
                        + "\" \" - 1\n" 
                        + "\"c\" - 2\n" 
                        + "\"a\" - 1\n" 
                        + "\"h\" - 1";
        assertEquals(expected, actual);
    }
}
