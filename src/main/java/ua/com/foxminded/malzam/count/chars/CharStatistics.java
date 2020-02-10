package ua.com.foxminded.malzam.count.chars;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharStatistics {

    public String getCharStatistics(String text) {

        validate(text);

        Map<String, String> queryHistory = new HashMap<>();
        String response;

        if (queryHistory.containsKey(text)) {
            response = queryHistory.get(text);
        } else {
            Map<Character, Integer> charStatistics = calculateCharStatistics(text);
            response = buildResponse(text, charStatistics);
            queryHistory.put(text, response);
        }
        return response;
    }

    private void validate(String text) {
        if (text == null) {
            throw new IllegalArgumentException("text is illegal argument null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("text is empty");
        }
    }

    private Map<Character, Integer> calculateCharStatistics(String text) {
        Map<Character, Integer> charStatistics = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character charText = text.charAt(i);

            if (charStatistics.containsKey(charText)) {
                Integer valueStatistics = charStatistics.get(charText) + 1;
                charStatistics.put(charText, valueStatistics);
            } else {
                charStatistics.put(charText, 1);
            }
        }
        return charStatistics;
    }

    private String buildResponse(String text, Map<Character, Integer> charStatistics) {
        StringBuilder builder = new StringBuilder(text);

        for (Map.Entry<Character, Integer> charEntry : charStatistics.entrySet()) {
            builder = builder.append("\n\"" + charEntry.getKey() + "\" - " + charEntry.getValue());
        }
        return builder.toString();
    }
}
