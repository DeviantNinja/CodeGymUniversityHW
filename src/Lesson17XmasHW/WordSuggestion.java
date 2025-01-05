package Lesson17XmasHW;

import java.util.*;

public class WordSuggestion {
    private HashMap<String, WordFrequency> wordList;

    public WordSuggestion() {
        wordList = new HashMap<>();
        loadDictionary();
    }

    public WordSuggestion(String dictionaryText){
        wordList = new HashMap<>();
        loadDictionary(dictionaryText);
    }

    public void update(String word) {
        update(word,"");
    }
    public void update(String word, String previousWord) {

        word = word.toLowerCase();
        previousWord = previousWord.toLowerCase();

        if (previousWord.isEmpty()) {
            wordList.put(word, new WordFrequency());
        } else {
            if (wordList.containsKey(previousWord)) {
                wordList.get(previousWord).update(word);
            } else {
                wordList.put(previousWord, new WordFrequency(word));
            }
        }
    }

    public ArrayList<String> mostUsedWords(String word, int numberOfWords) {
        return wordList.get(word).mostUsedWords(numberOfWords);
    }

    private void loadDictionary() {
        String defaultText = "Hello everyone, welcome to your first project specification. We’re going to recreate a simplified version of Google’s GBoard prediction of the next words when typing. As you can see below after typing a word, the keyboard is trying to predict the next 3 most likely words.";
        loadDictionary(defaultText);
    }

    private void loadDictionary(String text){
        boolean firstWord = true;
        int index = 0;

        TextReader reader = new TextReader();
        ArrayList<String> wordList = reader.getFormatedWords(text);

        for(String word : wordList) {
            if(firstWord){
                update(word);
                firstWord = false;
            } else {
                update(word,wordList.get(index - 1));
            }
            index++;
        }

    }


    @Override
    public String toString() {
        return "WordSuggestion{" +
                "wordList=" + wordList +
                '}';
    }
}
