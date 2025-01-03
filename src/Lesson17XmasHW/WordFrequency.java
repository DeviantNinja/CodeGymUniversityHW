package Lesson17XmasHW;

import java.util.*;

public class WordFrequency {
    HashMap<String, Integer> wordFrequency;

    public WordFrequency() {
        wordFrequency = new HashMap<>();
    }

    public WordFrequency(String word) {
        wordFrequency = new HashMap<>();
        update(word);
    }

    public void update(String word) {
        if (wordFrequency.containsKey(word)) {
            wordFrequency.replace(word, wordFrequency.get(word) + 1);
        } else {
            wordFrequency.put(word, 1);
        }
    }

    public ArrayList<String> mostUsedWords(int numberOfWords) {
        ArrayList<String> wordList = new ArrayList<>();
        int count = 0;
        int requiredWords;
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordFrequency.entrySet());
        entryList.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        requiredWords = Math.min(numberOfWords, entryList.size());

        for (Map.Entry<String, Integer> entry : entryList) {
            if (count++ < requiredWords) {
                wordList.add(entry.getKey());
            }
        }

        return wordList;
    }

    @Override
    public String toString() {
        return "WordFrequency{" +
                "wordFrequency=" + wordFrequency +
                '}';
    }
}
