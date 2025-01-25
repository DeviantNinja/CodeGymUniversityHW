package AutoCorrect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AutoCorrect {
    private final Map<Integer,Map<String,Integer>> dictionary;

    public AutoCorrect(String string) {
        dictionary = new HashMap<>();
        populateDictionary();
        getDistance(string);
    }

    private void populateDictionary() {
        Scanner sc;
        try {
            sc = new Scanner(new File("src\\AutoCorrect\\text2.csv"));
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
    public Map<String,Integer> getListOfWords(String word, int range) {
        int min = word.length() - range <= 1 ? 1 : word.length() - range;
        int max = word.length() + range;
        System.out.println("min: " + min + " Max: " + max);
        Map<String,Integer> wordList = new HashMap<>();

        for (int i = min; i <= max ; i++) {
            if(dictionary.containsKey(i)) {
                wordList.putAll(dictionary.get(i));
            }
        }
        return wordList;
    }

    public ArrayList<String> checkWord(String word) {
        if(isSpeltCorrectly(word)){
            return new ArrayList<>();
        }
        //check if letters are jumbled
        //sets cross section?
        //check distance



        //generate list of words with thier distance pick number of words with smallest word and largest frequncy.

        return null;
    }

    private void getDistance(String word){
        Map<String, Integer> wordList = getListOfWords(word,1);
        Map<Integer,Map<String,Integer>> wordsByDistance = new HashMap<>();

        for(String aWord : wordList.keySet()) {
            int distance = levDistance(word,aWord);
            if(wordsByDistance.containsKey(distance)) {
                wordsByDistance.get(distance).put(aWord, wordList.get(aWord));
            } else {
                wordsByDistance.put(distance,new HashMap<>());
                wordsByDistance.get(distance).put(aWord, wordList.get(aWord));
            }
        }
        System.out.println(wordsByDistance);
    }

//    private void getDistance(String word) {
//        Map<String, Integer> wordList = getListOfWords(word,0);
//        Map<Integer,String> newWordList = new TreeMap<>(Comparator.reverseOrder());
//        for(String aWord : wordList.keySet()){
//            int distance = levDistance(word,aWord);
//            if(distance <= 2) {
//                newWordList.put(wordList.get(aWord),aWord);
//            }
//        }
//        System.out.println(newWordList);
//
//    }



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

    //TODO write method to loop through word list and calculate distance. and then compare shortest distances with highest frequencies
    //TODO hmm need another list for frequencies/word lengths. consider tomorrow.


}


