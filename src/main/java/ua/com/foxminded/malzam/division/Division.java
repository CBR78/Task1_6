package ua.com.foxminded.malzam.division;

public class Division {

    public String integerDivision(int dividend, int divider) {
        String dividendString = String.valueOf(dividend);
        int dividendLength = dividendString.length();
        StringBuilder joiner = new StringBuilder();
        int remainder = 0;
        int endNumber = 1;
        for (int startNumber = 0; startNumber <= dividendLength - 1; startNumber = endNumber - 1) {
            boolean firstIteration = startNumber == 0;
            boolean lastIteration = startNumber == dividendLength - 1;
            int incDividend = 0;
            String remainderString = String.valueOf(remainder);
            for (; incDividend < divider; endNumber++) {
                String incDividendString = remainderString + dividendString.substring(startNumber, endNumber);
                incDividend = Integer.parseInt(incDividendString);
            }
            remainder = incDividend % divider;
            
            int incQuotient = incDividend - remainder;
            int sumSpaceDefault = endNumber - String.valueOf(incQuotient).length();
            int sumSpaceRemainder = endNumber - String.valueOf(remainder).length();
            int incDividendLength = String.valueOf(incDividend).length();
            String spaseAndPiped = elements(" ", dividendLength - incDividendLength) + ("|");
            int sumMarkersQuotient = dividendLength - incDividendLength + 1;

            if (firstIteration) {
                joiner.append("_" + dividend + "|" + divider);
            } else {
                joinIncDividend(joiner, incDividend, sumSpaceDefault);
            }
            joinIncQuotient(joiner, incQuotient, sumSpaceDefault);
            if (firstIteration) {
                joinMarkersQuotient(joiner, spaseAndPiped, sumMarkersQuotient);
            }
            joinMarkersUnderIncQuotient(joiner, incQuotient, sumSpaceDefault);
            if (firstIteration) {
                joinMarkersForReplacementWithDigitQuotient(joiner, spaseAndPiped, sumMarkersQuotient);
            }
            replacingMarkersWithDigitQuotient(joiner, incDividend, divider);
            if (lastIteration) {
                joinRemainder(joiner, remainder, sumSpaceRemainder);
            }
        }
        return joiner.toString();
    }

    private StringBuilder joinIncDividend(StringBuilder joiner, int incDividend, int sumSpaceDefault) {
        String initSpace = "\n" + elements(" ", sumSpaceDefault - 1) + "_";
        return joiner.append(initSpace + incDividend);
    }

    private StringBuilder joinIncQuotient(StringBuilder joiner, int incQuotient, int sumSpaceDefault) {
        String initSpace = "\n" + elements(" ", sumSpaceDefault);
        return joiner.append(initSpace + incQuotient);
    }

    private StringBuilder joinMarkersQuotient(StringBuilder joiner, String piped, int sumMarkersQuotient) {
        String markersQuotient = elements("-", sumMarkersQuotient);
        return joiner.append(piped + markersQuotient);
    }

    private StringBuilder joinMarkersUnderIncQuotient(StringBuilder joiner, int incQuotient, int sumSpaceDefault) {
        int incQuotientLength = String.valueOf(incQuotient).length();
        String initSpace = "\n" + elements(" ", sumSpaceDefault);
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

    private StringBuilder joinRemainder(StringBuilder joiner, int remainder, int sumSpaceRemainder) {
        String initSpace = "\n" + elements(" ", sumSpaceRemainder);
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
