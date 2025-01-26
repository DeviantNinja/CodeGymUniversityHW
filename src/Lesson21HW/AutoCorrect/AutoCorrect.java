package Lesson21HW.AutoCorrect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AutoCorrect {
    private final Map<Integer,Map<String,Integer>> dictionary;
    private final int DEFAULT_RANGE = 1;

    public AutoCorrect() {
        this(new File("src//Lesson21HW//AutoCorrect//DictionaryList.csv"));
    }

    public AutoCorrect(File dictionaryPath) {
        dictionary = new HashMap<>();
        populateDictionary(dictionaryPath);
    }

    public List<String> checkWord(String word, int noOfWords) {
        if(isSpeltCorrectly(word)){
            return new ArrayList<>();
        }
        return wordSuggestions(word, noOfWords);
    }

    private void populateDictionary(File dictionaryPath) {
        Scanner sc;
        try {
            sc = new Scanner(dictionaryPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            String word = line[0].toLowerCase();
            int wordLength = line[0].length();
            int wordFrequency = Integer.parseInt(line[1]);

            if(dictionary.containsKey(wordLength)) {
                dictionary.get(wordLength).put(word,wordFrequency);
            } else {
                dictionary.put(wordLength, new HashMap<>());
                dictionary.get(wordLength).put(word,wordFrequency);
            }
        }
    }


    private boolean isSpeltCorrectly(String word){
        return dictionary.get(word.length()).containsKey(word);
    }

    /*
        Returns a list of words and their frequencies that are within the
        specified range Cat,1 would return all words that are 2-4 characters
        in length.
     */
    private Map<String,Integer> getListOfWords(String word, int range) {
        int min = Math.max(word.length() - range, DEFAULT_RANGE);
        int max = word.length() + range;
        Map<String,Integer> wordList = new HashMap<>();

        for (int i = min; i <= max ; i++) {
            if(dictionary.containsKey(i)) {
                wordList.putAll(dictionary.get(i));
            }
        }
        return wordList;
    }

    /*
        Takes the word to be checked and the number of words to be returned.
        returns a List of words that require the fewest number of changes smallest to largest.
     */
    private List<String> wordSuggestions(String word, int noOfWords){
        Map<String, Integer> wordList = getListOfWords(word,2);
        Map<Integer,Map<String,Integer>> wordsByDistance = new HashMap<>();
        List<String> words = new ArrayList<>();

        //creates a Map of words grouped by Levenshtein distance
        for(String aWord : wordList.keySet()) {
            int distance = levDistance(word,aWord);
            if(wordsByDistance.containsKey(distance)) {
                wordsByDistance.get(distance).put(aWord, wordList.get(aWord));
            } else {
                wordsByDistance.put(distance,new HashMap<>());
                wordsByDistance.get(distance).put(aWord, wordList.get(aWord));
            }
        }

        //extracts a list of words smallest Levenshtein distance to largest
        //upto the number of words requested.
        for(Map.Entry<Integer,Map<String,Integer>> wordFreq : wordsByDistance.entrySet()) {
            for(String w : wordFreq.getValue().keySet()){
                if(words.size() != noOfWords) {
                    words.add(w);
                } else {
                    return words;
                }
            }
        }
        return words;
    }

    //calculates the number of times a letter needs to be added, removed or changed.
    //used to find the words with the samllesst number of changes.
    //https://www.baeldung.com/cs/levenshtein-distance-computation
    private int levDistance(String word1, String word2) {
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    matrix[i][j] = j;
                } else if (j == 0) {
                    matrix[i][j] = i;
                } else {
                    matrix[i][j] = Math.min(
                            matrix[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1), // Substitution
                            Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1) // Insertion and Deletion
                    );
                }
            }
        }
        return matrix[word1.length()][word2.length()];
    }
}


