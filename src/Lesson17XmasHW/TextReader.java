package Lesson17XmasHW;

import java.util.ArrayList;

public class TextReader {
    public TextReader() {
    }

    //created an individual method so that I could use edge cases later.
    private String[] formatText(String text) {
        return text.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
    }

    public ArrayList<String> getFormatedWords() {
        String DEFAULT_TEXT = "A 1Quick Brown2 !Fox ,  Jumped@ 123Over T7he Lazy Dog";
        return getFormatedWords(DEFAULT_TEXT);
    }

    public ArrayList<String> getFormatedWords(String string) {
        ArrayList<String> wordList = new ArrayList<>();
        for(String word : formatText(string) ) {
            if(!word.isEmpty() && !word.equals(" ")){
                wordList.add(word);
            }
        }
        return wordList;
    }
}
