package ua.com.foxminded.malzam.division;

public class Division {

    public String makeDivision(int dividend, int divider) {
        int absDividend = Math.abs(dividend);
        int absDivider = Math.abs(divider);
        checkIllegalArgumentExceptions(absDividend, absDivider);
        String absDividendString = String.valueOf(absDividend);
        int absDividendLength = absDividendString.length();
        StringBuilder builder = new StringBuilder();
        int remainder = 0;
        int endNumber = 1;

        for (int startNumber = 0; startNumber <= absDividendLength - 1; startNumber = endNumber - 1) {
            int incDividend = 0;
            String remainderString = String.valueOf(remainder);

            for (; incDividend < absDivider; endNumber++) {
                String incDividendString = remainderString + absDividendString.substring(startNumber, endNumber);
                incDividend = Integer.parseInt(incDividendString);
            }

            boolean firstIteration = startNumber == 0;
            boolean lastIteration = endNumber == absDividendLength + 1;
            remainder = incDividend % absDivider;
            int incQuotient = incDividend - remainder;
            int sumSpaceDefault = endNumber - String.valueOf(incQuotient).length();
            int sumSpaceRemainder = endNumber - String.valueOf(remainder).length();
            int incDividendLength = String.valueOf(incDividend).length();
            String spaseAndPiped = makeChainElements(" ", absDividendLength - incDividendLength) + ("|");
            int sumMarkersQuotient = absDividendLength - incDividendLength + 1;

            if (firstIteration) {
                builder.append("_" + absDividend + "|" + absDivider);
                joinIncQuotient(builder, incQuotient, sumSpaceDefault);
                joinMarkersQuotient(builder, spaseAndPiped, sumMarkersQuotient);
                joinMarkersUnderIncQuotient(builder, incQuotient, sumSpaceDefault);
                joinMarkersForReplacementWithDigitQuotient(builder, spaseAndPiped, sumMarkersQuotient);
                replaceMarkersWithDigitQuotient(builder, incDividend, absDivider);
            } else {
                joinIncDividend(builder, incDividend, sumSpaceDefault);
                joinIncQuotient(builder, incQuotient, sumSpaceDefault);
                joinMarkersUnderIncQuotient(builder, incQuotient, sumSpaceDefault);
                replaceMarkersWithDigitQuotient(builder, incDividend, absDivider);
            }
            if (lastIteration) {
                joinRemainder(builder, remainder, sumSpaceRemainder);
            }
        }
        return builder.toString();
    }
    
    private void checkIllegalArgumentExceptions(int absDividend, int absDivider) {
        if (absDividend == 0) {
            throw new IllegalArgumentException("Dividend cannot be 0, \"0/" + absDivider + "=0\"");
        }
        if (absDivider == 0) {
            throw new IllegalArgumentException("Divider cannot be 0, division by zero");
        }
        if (absDividend < absDivider) {
            throw new IllegalArgumentException(
                    "Dividend cannot be less than the Divisor, \"" + absDividend + "\\" + absDivider + "=0\"");
        }
    }

    private StringBuilder joinIncDividend(StringBuilder builder, int incDividend, int sumSpaceDefault) {
        String initSpace = "\n" + makeChainElements(" ", sumSpaceDefault - 1) + "_";
        return builder.append(initSpace + incDividend);
    }

    private StringBuilder joinIncQuotient(StringBuilder builder, int incQuotient, int sumSpaceDefault) {
        String initSpace = "\n" + makeChainElements(" ", sumSpaceDefault);
        return builder.append(initSpace + incQuotient);
    }

    private StringBuilder joinMarkersQuotient(StringBuilder builder, String piped, int sumMarkersQuotient) {
        String markersQuotient = makeChainElements("-", sumMarkersQuotient);
        return builder.append(piped + markersQuotient);
    }

    private StringBuilder joinMarkersUnderIncQuotient(StringBuilder builder, int incQuotient, int sumSpaceDefault) {
        int incQuotientLength = String.valueOf(incQuotient).length();
        String initSpace = "\n" + makeChainElements(" ", sumSpaceDefault);
        String markersUnderIncQuotient = makeChainElements("-", incQuotientLength);
        return builder.append(initSpace + markersUnderIncQuotient);
    }

    private StringBuilder joinMarkersForReplacementWithDigitQuotient(StringBuilder builder, String piped,
            int sumMarkersQuotient) {
        String markersQuotient = makeChainElements(".", sumMarkersQuotient);
        return builder.append(piped + markersQuotient);
    }

    private StringBuilder replaceMarkersWithDigitQuotient(StringBuilder builder, int incDividend, int absDivider) {
        int indexForSet = builder.indexOf(".");
        int maxMultiplierIncDividend = incDividend / absDivider;
        char[] digitQuotient = String.valueOf(maxMultiplierIncDividend).toCharArray();
        builder.setCharAt(indexForSet, digitQuotient[0]);
        return builder;
    }

    private StringBuilder joinRemainder(StringBuilder builder, int remainder, int sumSpaceRemainder) {
        String initSpace = "\n" + makeChainElements(" ", sumSpaceRemainder);
        return builder.append(initSpace + remainder);
    }

    private String makeChainElements(String element, int sum) {
        StringBuilder elements = new StringBuilder();
        for (int i = 0; i < sum; i++) {
            elements.append(element);
        }
        return elements.toString();
    }
}
