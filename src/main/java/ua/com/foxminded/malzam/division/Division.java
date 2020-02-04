package ua.com.foxminded.malzam.division;

public class Division {

    public String makeDivision(int dividend, int divider) {
        int absDividend = Math.abs(dividend);
        int absDivider = Math.abs(divider);
        
        validate(absDividend, absDivider);
        
        String absDividendString = String.valueOf(absDividend);
        int absDividendLength = absDividendString.length();
        StringBuilder builder = new StringBuilder();
        int remainder = 0;
        int endNumber = 1;

        for (int startNumber = 0; startNumber <= absDividendLength - 1; startNumber = endNumber - 1) {
            int incDividend = 0;
            String remainderString = String.valueOf(remainder);

            while (incDividend < absDivider) {
                String incDividendString = remainderString + absDividendString.substring(startNumber, endNumber);
                incDividend = Integer.parseInt(incDividendString);
                endNumber++;
            }

            remainder = incDividend % absDivider;
            int incQuotient = incDividend - remainder;
            int sumSpace = endNumber - String.valueOf(incQuotient).length();
            int incDividendLength = String.valueOf(incDividend).length();
            String spaseAndPiped = makeChainElements(" ", absDividendLength - incDividendLength) + ("|");
            int sumMarkersQuotient = absDividendLength - incDividendLength + 1;

            if (startNumber == 0) {
                builder.append("_" + absDividend + "|" + absDivider);
                joinIncQuotient(builder, incQuotient, sumSpace);
                joinMarkersQuotient(builder, spaseAndPiped, sumMarkersQuotient);
                joinMarkersUnderIncQuotient(builder, incQuotient, sumSpace);
                joinMarkersForReplacementWithDigitQuotient(builder, spaseAndPiped, sumMarkersQuotient);
                replaceMarkersWithDigitQuotient(builder, incDividend, absDivider);
            } else {
                joinIncDividend(builder, incDividend, sumSpace);
                joinIncQuotient(builder, incQuotient, sumSpace);
                joinMarkersUnderIncQuotient(builder, incQuotient, sumSpace);
                replaceMarkersWithDigitQuotient(builder, incDividend, absDivider);
            }
        }
        joinRemainder(builder, remainder, endNumber);
        return builder.toString();
    }
    
    private void validate(int absDividend, int absDivider) {
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

    private StringBuilder joinIncDividend(StringBuilder builder, int incDividend, int sumSpace) {
        String initSpace = "\n" + makeChainElements(" ", sumSpace - 1) + "_";
        return builder.append(initSpace + incDividend);
    }

    private StringBuilder joinIncQuotient(StringBuilder builder, int incQuotient, int sumSpace) {
        String initSpace = "\n" + makeChainElements(" ", sumSpace);
        return builder.append(initSpace + incQuotient);
    }

    private StringBuilder joinMarkersQuotient(StringBuilder builder, String piped, int sumMarkersQuotient) {
        String markersQuotient = makeChainElements("-", sumMarkersQuotient);
        return builder.append(piped + markersQuotient);
    }

    private StringBuilder joinMarkersUnderIncQuotient(StringBuilder builder, int incQuotient, int sumSpace) {
        int incQuotientLength = String.valueOf(incQuotient).length();
        String initSpace = "\n" + makeChainElements(" ", sumSpace);
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

    private StringBuilder joinRemainder(StringBuilder builder, int remainder, int endNumber) {
        int sumSpace = endNumber - String.valueOf(remainder).length();
        String initSpace = "\n" + makeChainElements(" ", sumSpace);
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
