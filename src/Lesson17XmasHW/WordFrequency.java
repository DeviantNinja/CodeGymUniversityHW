package Lesson17XmasHW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {
    private final int DEFAULT_NUMBER_OF_WORDS = 3;
    private TreeMap<String,Integer>  wordUsage = new TreeMap<>();

    public WordFrequency() {
    }

    public String[] getMostUsedWords(){
        return getMostUsedWords(DEFAULT_NUMBER_OF_WORDS);
    }

    public String[] getMostUsedWords(int numberOfWords) {
        //TODO impliment code for words to be returend.
        return new String[] {"test1","test2","test3"};
    }



    /**
     * Add word to list with default value of 1
     * @param word String containing word to be added
     */
    private void AddWord(String word) {
        wordUsage.put(word, 1);
    }

    /**
     * checks if a word is in the list, if the word is not
     * in the list will call the add word method to add word
     * to list
     * @param word String containing word to be added
     */
    public void updateWord(String word) {
        if(wordUsage.containsKey(word)) {
            wordUsage.replace(word, wordUsage.get(word)+1);
        } else {
            AddWord(word);
        }
    }

    /***
     * Loads Default list of words static for now would like
     * to add a document import
     */

    @Override
    public String toString() {
        return "WordFrequency{" +
                "wordUsage=" + wordUsage +
                '}';
    }
}
