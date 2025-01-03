package Lesson17XmasHW;

import java.util.*;

public class WordSuggestion {
    HashMap<String,WordFrequency> wordList;

    public WordSuggestion() {
        wordList = new HashMap<>();
    }

    public void update(String word, String previousWord){

        word = word.toLowerCase();
        previousWord = previousWord.toLowerCase();

        if(previousWord.isEmpty()) {
            wordList.put(word, new WordFrequency());
        } else {
            if(wordList.containsKey(previousWord)) {
                wordList.get(previousWord).update(word);
            } else {
                wordList.put(previousWord, new WordFrequency(word));
            }
        }
    }

    public ArrayList<String> mostUsedWords(String word, int numberOfWords) {
        return wordList.get(word).mostUsedWords(numberOfWords);
    }


    @Override
    public String toString() {
        return "WordSuggestion{" +
                "wordList=" + wordList +
                '}';
    }
}
