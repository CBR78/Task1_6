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
            remainder = incDividend % divider;
            
            boolean firstIteration = startNumber == 0;
            boolean lastIteration = startNumber == dividendLength - 1;
            int incQuotient = incDividend - remainder;
            int incDividendLength = String.valueOf(incDividend).length();
            String piped = elements(" ", dividendLength - incDividendLength + 1) + ("|");
            int sumMarkersQuotient = dividendLength - incDividendLength + 1;

            if (firstIteration) {
                joiner.append("_" + dividend + "|" + divider);
            } else {
                joinIncDividend(joiner, incDividend, startNumber);
            }
            joinIncQuotient(joiner, incQuotient, startNumber);
            if (firstIteration) {
                joinMarkersQuotient(joiner, piped, sumMarkersQuotient);
            }
            joinMarkersUnderIncQuotient(joiner, incQuotient, startNumber);
            if (firstIteration) {
                joinMarkersForReplacementWithDigitQuotient(joiner, piped, sumMarkersQuotient);
            }
            replacingMarkersWithDigitQuotient(joiner, incDividend, divider);
            if (lastIteration) {
                joinRemainder(joiner, remainder, startNumber);
            }
        }
        return joiner.toString();
    }

    private StringBuilder joinIncDividend(StringBuilder joiner, int incDividend, int startNumber) {
        String initSpace = "\n" + elements(" ", startNumber - 1) + "_";
        return joiner.append(initSpace + incDividend);
    }

    private StringBuilder joinIncQuotient(StringBuilder joiner, int incQuotient, int startNumber) {
        String initSpace = "\n" + elements(" ", startNumber);
        return joiner.append(initSpace + incQuotient);
    }

    private StringBuilder joinMarkersQuotient(StringBuilder joiner, String piped, int sumMarkersQuotient) {
        String markersQuotient = elements("-", sumMarkersQuotient);
        return joiner.append(piped + markersQuotient);
    }

    private StringBuilder joinMarkersUnderIncQuotient(StringBuilder joiner, int incQuotient, int startNumber) {
        int incQuotientLength = String.valueOf(incQuotient).length();
        String initSpace = "\n" + elements(" ", startNumber);
        String markersUnderIncQuotient = elements("-", incQuotientLength);
        return joiner.append(initSpace + markersUnderIncQuotient);
    }

    private StringBuilder joinMarkersForReplacementWithDigitQuotient(StringBuilder joiner, String piped,
            int sumMarkersQuotient) {
        String markersQuotient = elements(".", sumMarkersQuotient);
        return joiner.append(piped + markersQuotient);
    }

    private StringBuilder replacingMarkersWithDigitQuotient(StringBuilder joiner, int incDividend, int divider) {
        int indexForSet = joiner.indexOf(".");
        int maxMultiplierIncDividend = incDividend / divider;
        char[] digitQuotient = String.valueOf(maxMultiplierIncDividend).toCharArray();
        joiner.setCharAt(indexForSet, digitQuotient[0]);
        return joiner;
    }

    private StringBuilder joinRemainder(StringBuilder joiner, int remainder, int startNumber) {
        String initSpace = "\n" + elements(" ", startNumber + 1);
        return joiner.append(initSpace + remainder).append("\n ");
    }

    private String elements(String element, int sum) {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < sum; i++) {
            elements.append(element);
        }
        return elements.toString();
    }
}
