package Lesson17XmasHW;

import java.util.HashMap;

public class WordSuggestion {
    private HashMap<String,WordFrequency> wordList;

    public WordSuggestion() {
        wordList = new HashMap<>();
        defaultList();
    }

    public void checkWord(String word) {
        if(wordList.containsKey(word)) {
            getMostUsedWords(word);
        } else {
            wordList.put(word,new WordFrequency());
        }
    }


    private void defaultList() {
        wordList.put("Michael", new WordFrequency());
        wordList.put("John", new WordFrequency());
    }

    public void getMostUsedWords(String word) {
        for(String aWord : wordList.get(word).getMostUsedWords()) {
            System.out.print(aWord + " ");
        }
    }
}
