package Lesson10HW;

import java.util.Arrays;

public class Homework {

    /**
     * Home work for week 10 as well as the binary, hex, decimal convertors
     * have created individual classes for each as i wanted to try some new things
     * object creation and test cases are located in the converter test method.
     */
    public static void main(String[] args) {
        System.out.println(mostUsedLetter("aaabbbccc"));
        System.out.println(isAnagram("apple","ppale"));
        System.out.println(compressString("bananaaa"));

        converterTests();
    }

    private static void converterTests() {
//        Hexadecimal hex = new Hexadecimal();
//        System.out.println(hex.toDecimal("3ab"));
//        System.out.println(hex.toDecimal("3AB"));
//        System.out.println(hex.toDecimal("F"));
//        System.out.println(hex.toBinary("3ab"));
//        System.out.println(hex.toBinary("F"));
//        System.out.println(hex.toBinary("0"));

//        Decimal decimal = new Decimal();
//        System.out.println(decimal.toHex(10));
//        System.out.println(decimal.toHex(15));
//        System.out.println(decimal.toHex(255));
//        System.out.println(decimal.toHex(6553));
//        System.out.println(decimal.toHex(0));
//        System.out.println(decimal.toBinary(10));
//        System.out.println(decimal.toBinary(15));
//        System.out.println(decimal.toBinary(255));
//        System.out.println(decimal.toBinary(6553));
//        System.out.println(decimal.toBinary(0));

//        Binary binary = new Binary();
//        System.out.println(binary.toDecimal("0"));
//        System.out.println(binary.toDecimal("1"));
//        System.out.println(binary.toDecimal("1111"));
//        System.out.println(binary.toDecimal("11111111"));
//        System.out.println(binary.toDecimal("1011001111011"));
//        System.out.println(binary.toHex("111111"));
//        System.out.println(binary.toHex("1"));
//        System.out.println(binary.toHex("1111"));
//        System.out.println(binary.toHex("11111111"));
//        System.out.println(binary.toHex("1011001111011"));
    }

    /**
     * 1. Find and return the most common letter in a given string.
     * calculates the most used letter, if multiple letters
     * have the same quantity will return the first alphabetically
     */
    public static char mostUsedLetter(String string) {
        char[] stringArray = string.toLowerCase().toCharArray();
        char tempChar;
        char mostUsed;
        int count = 1;
        int highestCount = 0;

        Arrays.sort(stringArray);
        mostUsed = tempChar = stringArray[0];

        for (int i = 1; i < stringArray.length ; i++) {
            if(tempChar == stringArray[i]) {
                count++;
            } else {
                tempChar = stringArray[i];
                count = 1;
            }
            if(count > highestCount) {
                highestCount = count;
                mostUsed = tempChar;
            }
        }
        return mostUsed;
    }

    /**
     *  2. Check if 2 strings are anagrams of each other (below - elbow, end - ned, apple - ppale)
     */
    public static boolean isAnagram(String firstWord, String secondWord){
        if((firstWord == null || firstWord.isEmpty()) || (secondWord == null || secondWord.isEmpty())) return false;
        if(firstWord.length() != secondWord.length()) return false;

        char[] sortedFirstWord = firstWord.toCharArray();
        char[] sortedSecondWord = secondWord.toCharArray();
        Arrays.sort(sortedFirstWord);
        Arrays.sort(sortedSecondWord);

        for (int i = 0; i < sortedFirstWord.length; i++) {
            if(sortedFirstWord[i] != sortedSecondWord[i]){
                return false;
            }
        }
        return true;
    }

    /**
     *  3. Compress a string using the following rule: aaabccc = a3bc3
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
}
