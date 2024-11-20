package Lesson11HW;

public class Homeworkv2 {
    public static void main(String[] args) {
        System.out.println(mostUsedLetter("?aaaz  zzzbbb"));
        System.out.println(isAnagram("racar","carer"));
        System.out.println(compressString("aaa"));
        System.out.println(decompressString(compressString("aaa")));
        System.out.println();

    }

    /**
     *  3a. Compress a string using the following rule: aaabccc = a3bc3
     */
    public static String compressString(String string) {
        StringBuilder compressedString = new StringBuilder();
        char tempChar = string.toLowerCase().charAt(0);
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            if(tempChar == string.toLowerCase().charAt(i)){
                count++;
            } else {
                compressedString.append(tempChar);
                if(count > 1) {
                    compressedString.append(count);
                }
                tempChar = string.toLowerCase().charAt(i);
                count = 1;
            }
        }
        compressedString.append(tempChar);
        if(count > 1) {
            compressedString.append(count);
        }
        return compressedString.toString();
    }

    /**
     *  3b. decompress a string using the following rule: a3bc3 = aaabccc
     */
    public static String decompressString(String string){
        StringBuilder dString = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            if(i+1 < string.length() && Character.isDigit(string.charAt(i+1))){
                for (int j = 0; j < Character.getNumericValue(string.charAt(i+1)); j++) {
                    dString.append(string.charAt(i));
                }
                i++;
            } else {
                dString.append(string.charAt(i));
            }
        }
        return dString.toString();
    }

    /**
     *  2. Check if 2 strings are anagrams of each other (below - elbow, end - ned, apple - ppale)
     */
    public static boolean isAnagram(String firstWord, String secondWord){
        if(firstWord.length() != secondWord.length()) return false;
        if(!containsLetter(firstWord) || !containsLetter(secondWord)) return false;

        int[] firstWordLetters = calculateLettersUsed(firstWord);
        int[] secondWordLetters = calculateLettersUsed(secondWord);

        for (int i = 0; i < firstWordLetters.length; i++) {
            if(firstWordLetters[i] != secondWordLetters[i]){
                return false;
            }
        }
        return true;
    }

    /**
     *  returns the most used letter alphabetically
     */
    public static char mostUsedLetter(String string){
        if(!containsLetter(string)) return '\u0000';
        int[] letterCount = calculateLettersUsed(string);
        int highestCount = 0;
        char mostUsedLetter = 'a'; // as containsLetter checks that there is at least 1 letter in it

        for (int i = 0; i < letterCount.length ; i++) {
            if(letterCount[i] > highestCount) {
                highestCount = letterCount[i];
                mostUsedLetter = (char) (i + 97);
            }
        }
        return mostUsedLetter;
    }

    /**
     * counts usages of letters a-z and returns an array of count of each letter
     *  (char) index + 97 to convert index to letter
     */
    private static int[] calculateLettersUsed(String string) {
        int[] letterCount = new int[26];
        int letterValue;
        for(char letter : string.toLowerCase().toCharArray()){
            letterValue = letter;
            if(letterValue >= 'a' && letterValue <= 'z') {
                letterCount[letterValue - 97]++;
            }
        }
        return letterCount;
    }

    public static boolean containsLetter(String string){
        return string.matches(".*[a-zA-Z].*");
    }

}
