package ua.com.foxminded.malzam.division;

public class Division {

    public String integerDivision(int dividend, int divider) {

        // первая строка
        StringBuilder result = new StringBuilder();
        result = result.append("_" + dividend + "|" + divider);

        // расчет неполного делимого
        String dividendString = String.valueOf(dividend);
        String incompleteDividendString = new String();
        int remainder = 0;
        int dividendLength = String.valueOf(dividend).length();
        int j = 1;
        for (int i = 0; i <= dividendLength - 1;) {
            int incompleteDividend = 0;
            String remainderString = String.valueOf(remainder);
            // неполное делимое
            for (; divider >= incompleteDividend; j++) {
                incompleteDividendString = remainderString + dividendString.substring(i, j);
                incompleteDividend = Integer.parseInt(incompleteDividendString);
            }
            
            boolean markFirstIteration;
            if (i > 0) {
                markFirstIteration = true; 
            } else {
                markFirstIteration = false;
            }
            
            StringBuilder spase = multiElements(" ", i - 1);
            StringBuilder piped = new StringBuilder("");
            StringBuilder quotientMark = new StringBuilder("");
            StringBuilder multiplierMark = new StringBuilder("");
            if (markFirstIteration) {
                result = result.append("\n" + spase + "_" + incompleteDividend); // неполное делимое
            } else {
                int incompleteDividendLength = String.valueOf(incompleteDividend).length();
                piped = multiElements(" ", dividendLength - incompleteDividendLength).append("|");
                quotientMark = multiElements("-", dividendLength - incompleteDividendLength + 1);
                multiplierMark = multiElements("x", dividendLength - incompleteDividendLength + 1);
            }
            i = j - 1;

            // неполное частное
            int incompleteQuotient = 0;
            int k = 0;
            for (; incompleteDividend >= incompleteQuotient; k++) {
                incompleteQuotient = divider * k;
            }
            int incompleteMultiplier = k - 2;
            incompleteQuotient = divider * incompleteMultiplier;
            result = result.append("\n " + spase + incompleteQuotient + piped + quotientMark); // неполное частное

            // маркеры под неполным частным
            int incompleteQuotientLength = String.valueOf(incompleteQuotient).length();
            result = result.append("\n " + spase + multiElements("-", incompleteQuotientLength) + piped + multiplierMark);
            
            // вставка неполного частного в поле для полного частного
            int indexForInsert = result.indexOf("x");
            //result.insert(indexForInsert, incompleteMultiplier);
            char incompleteMultiplierChar[] = String.valueOf(incompleteMultiplier).toCharArray();
            result.setCharAt(indexForInsert, incompleteMultiplierChar[0]);
            
            // остаток деления
            remainder = incompleteDividend - incompleteQuotient;
            if (i > dividendLength - 1) {
                result = result.append("\n  " + spase + remainder); // остаток деления
            }
        }
        return result.append("\n ").toString();
    }

    public StringBuilder multiElements(String element, int sum) {
        StringBuilder multiElements = new StringBuilder();
        for (int l = 0; l < sum; l++) {
            multiElements.append(element);
        }
        return multiElements;
    }
}
