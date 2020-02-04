package ua.com.foxminded.malzam.division;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivisionTest {

    Division division = new Division();

    @Test
    public void makeDivision_Expect_IllegalArgumentException_ifDividend_isNull() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(0, 20));
    }

    @Test
    public void makeDivision_Expect_IllegalArgumentException_ifDivider_isNull() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(20, 0));
    }
    
    @Test
    public void makeDivision_Expect_IllegalArgumentException_ifDividend_isLessThanDivisor() {
        assertThrows(IllegalArgumentException.class, () -> division.makeDivision(10, 15));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDividend_is78945_andDivider_is4() {
        assertEquals("_78945|4\n"
                   + " 4    |-----\n"
                   + " -    |19736\n"
                   + "_38\n"
                   + " 36\n"
                   + " --\n"
                   + " _29\n"
                   + "  28\n"
                   + "  --\n"
                   + "  _14\n"
                   + "   12\n"
                   + "   --\n"
                   + "   _25\n"
                   + "    24\n"
                   + "    --\n"
                   + "     1", division.makeDivision(78945, 4));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDividend_is512_andDivider_is8() {
        assertEquals("_512|8\n"
                   + " 48 |--\n"
                   + " -- |64\n"
                   + " _32\n"
                   + "  32\n"
                   + "  --\n"
                   + "   0",
                division.makeDivision(512, 8));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDividend_is1004_andDivider_is4() {
        assertEquals("_1004|4\n"
                   + "  8  |---\n"
                   + "  -  |251\n"
                   + " _20\n"
                   + "  20\n"
                   + "  --\n"
                   + "   _4\n"
                   + "    4\n"
                   + "    -\n"
                   + "    0", division.makeDivision(1004, 4));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifSumIteration_isOne() {
        assertEquals("_102|102\n"
                   + " 102|-\n"
                   + " ---|1\n"
                   + "   0", division.makeDivision(102, 102));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDividend_isNegativeNumber() {
        assertEquals("_102|8\n"
                   + "  8 |--\n"
                   + "  - |12\n"
                   + " _22\n"
                   + "  16\n"
                   + "  --\n"
                   + "   6", division.makeDivision(-102, 8));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDivider_isNegativeNumber() {
        assertEquals("_102|8\n"
                   + "  8 |--\n"
                   + "  - |12\n"
                   + " _22\n"
                   + "  16\n"
                   + "  --\n"
                   + "   6", division.makeDivision(102, -8));
    }

    @Test
    public void makeDivision_Expect_TargetString_ifDividend_isNegativeNumber_andDivider_isNegativeNumber() {
        assertEquals("_102|8\n"
                   + "  8 |--\n"
                   + "  - |12\n"
                   + " _22\n"
                   + "  16\n"
                   + "  --\n"
                   + "   6", division.makeDivision(-102, -8));
    }
}
