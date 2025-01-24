package AutoCorrect;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AutoCorrect {
    /**
     * Step 1: Dictionary of correct words
     * Step 2: Method to check if word if spelling is correct
     * step 3:
     */
    private final Set<String> dictionary;

    public AutoCorrect(){
        dictionary = new HashSet<>();
        populateDictionary();
    }

    private boolean isSpeltCorrectly(String word){
        return dictionary.contains(word);
    }

    private int wordDistanceCalculation() {
        //TODO steal levenshtien distance algorithm.
        return 1;
    }

    //TODO write method to get list of words to measure distance. return a List of some sort with words that are +/- 1 character?
    //TODO write method to loop through word list and calculate distance. and then compare shortest distances with highest fequencies
    //TODO hmm need another list for frequencies/word lengths. concider tomorrow.

    private void populateDictionary() {
        Scanner sc;
        try {
            sc = new Scanner(new File("src\\AutoCorrect\\text2.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            dictionary.add(line[0]);
        }
    }
}
