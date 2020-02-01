package ua.com.foxminded.malzam.division;

public class Division {

    public String integerDivision(int dividend, int divider) {
        String dividendString = String.valueOf(dividend);
        int dividendLength = dividendString.length();
        StringBuilder joiner = new StringBuilder();
        int remainder = 0;
        int endNumber = 1;
        for (int startNumber = 0; startNumber <= dividendLength - 1; startNumber = endNumber - 1) {
            int incDividend = 0;
            String remainderString = String.valueOf(remainder);
            for (; divider >= incDividend; endNumber++) {
                String incDividendString = remainderString + dividendString.substring(startNumber, endNumber);
                incDividend = Integer.parseInt(incDividendString);
            }
            boolean firstIteration = startNumber == 0;
            if (firstIteration) {
                joiner = joiner.append("_" + dividend + "|" + divider); // first string - dividend | divider
            } else {
                String initSpace = "\n" + elements(" ", startNumber - 1) + "_";
                joiner = joiner.append(initSpace + incDividend); // incDividend
            }

            int incQuotient = divider * maxMultiplierIncDividend(incDividend, divider);
            String initSpace = "\n" + elements(" ", startNumber);
            joiner = joiner.append(initSpace + incQuotient); // incQuotient

            int incDividendLength = String.valueOf(incDividend).length();
            String piped = elements(" ", dividendLength - incDividendLength + 1) + ("|");
            int sumMarkersQuotient = dividendLength - incDividendLength + 1;
            String markersQuotient = elements("-", sumMarkersQuotient);
            if (firstIteration) {
                joiner = joiner.append(piped + markersQuotient); // "|" + markersQuotient ("-")
            }

            int incQuotientLength = String.valueOf(incQuotient).length();
            initSpace = "\n" + elements(" ", startNumber);
            String markersUnderIncQuotient = elements("-", incQuotientLength);
            joiner = joiner.append(initSpace + markersUnderIncQuotient); // markersUnderIncQuotient

            if (firstIteration) {
                markersQuotient = elements(".", sumMarkersQuotient);
                joiner = joiner.append(piped + markersQuotient); // markers for replacement with digitQuotient
            }
            int indexForSet = joiner.indexOf(".");
            char[] digitQuotient = String.valueOf(maxMultiplierIncDividend(incDividend, divider)).toCharArray();
            joiner.setCharAt(indexForSet, digitQuotient[0]); // replacing markers with digitQuotient

            remainder = incDividend - incQuotient;
            boolean lastIteration = startNumber == dividendLength - 1;
            if (lastIteration) {
                initSpace = "\n" + elements(" ", startNumber + 1);
                joiner = joiner.append(initSpace + remainder); // add remainder
            }
        }
        return joiner.append("\n ").toString();
    }

    private int maxMultiplierIncDividend(int incDividend, int divider) {
        int multiplier = 0;
        for (int incQuotient = 0; incDividend >= incQuotient; multiplier++) {
            incQuotient = divider * multiplier;
        }
        return multiplier - 2;
    }

    private String elements(String element, int sum) {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < sum; i++) {
            elements.append(element);
        }
        return elements.toString();
    }
}
