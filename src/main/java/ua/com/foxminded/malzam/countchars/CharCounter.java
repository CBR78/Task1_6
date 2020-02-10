package ua.com.foxminded.malzam.countchars;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {

    Map<String, String> textCache = new HashMap<>();

    public String countChars(String text) {

        validate(text);

        String response;

        if (textCache.containsKey(text)) {
            response = textCache.get(text);
        } else {
            Map<Character, Integer> charCounter = calculateChars(text);
            response = buildResponse(text, charCounter);
            textCache.put(text, response);
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

    private Map<Character, Integer> calculateChars(String text) {
        Map<Character, Integer> charCounter = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character charText = text.charAt(i);

            if (charCounter.containsKey(charText)) {
                Integer value = charCounter.get(charText) + 1;
                charCounter.put(charText, value);
            } else {
                charCounter.put(charText, 1);
            }
        }
        return charCounter;
    }

    private String buildResponse(String text, Map<Character, Integer> charCounter) {
        StringBuilder builder = new StringBuilder(text);

        for (Map.Entry<Character, Integer> charEntry : charCounter.entrySet()) {
            builder = builder.append("\n\"" + charEntry.getKey() + "\" - " + charEntry.getValue());
        }
        return builder.toString();
    }
}
