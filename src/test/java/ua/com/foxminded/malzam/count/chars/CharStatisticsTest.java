package ua.com.foxminded.malzam.count.chars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharStatisticsTest {

    CharStatistics charStatistics = new CharStatistics();

    @Test
    public void charStatistics_Expect_IllegalArgumentException_IfText_IsNull() {
        assertThrows(IllegalArgumentException.class, () -> charStatistics.getCharStatistics(null));
    }

    @Test
    public void charStatistics_Expect_IllegalArgumentException_IfText_IsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> charStatistics.getCharStatistics(""));
    }

    @Test
    public void charStatistics_Expect_IfText_IsHelloWorld() {
        assertEquals("hello world!\n"
                   + "\"h\" - 1\n"
                   + "\"e\" - 1\n" 
                   + "\"l\" - 3\n" 
                   + "\"o\" - 2\n" 
                   + "\" \" - 1\n" 
                   + "\"w\" - 1\n" 
                   + "\"r\" - 1\n" 
                   + "\"d\" - 1\n" 
                   + "\"!\" - 1", charStatistics.getCharStatistics("hello world!"));
    }

    @Test
    public void charStatistics_Expect_IfText_IsHelloWorldAndDigit() {
        assertEquals("he8826llo worl87d!\n" 
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
                   + "\"!\" - 1", charStatistics.getCharStatistics("he8826llo worl87d!"));
    }
    
}
