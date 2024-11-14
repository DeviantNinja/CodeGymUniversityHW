package Lesson9HW;
// Additional HW:
// 1. Check if a string is a palindrome. Palindrome means that it
// 2. Reverse the words in a given string.
// 3. In a given array of Strings, find the longest common prefix.
// [apple, application, ape] => ap
// [apple, application, banana] => empty string
public class Homework {


    public static void main(String[] args) {
        String[] Words = {"apple", "application", "ape"};
        System.out.println(longestCommonPrefix(Words));

        System.out.println(checkPalindrome("Racar"));

        System.out.println(reverseString("A Quick Brown Fox Jumped Over Something"));

    }

    /**
     * 1. Check if a string is a palindrome. Palindrome means that it
     */
    public static boolean checkPalindrome (String word) {

        for(int i = 0; i < word.length() / 2; i++){
            if(word.toLowerCase().charAt(i) == word.toLowerCase().charAt(word.length() - 1 - i)) {
                continue;
            } else return false;
        }
        return true;
    }

    /**
     * 2. Reverse the words in a given string.
     */
    public static String reverseString(String string) {
        String[] temp = string.split(" ");
        String tempString = "";

        for (int i = temp.length - 1; i >= 0; i--) {
            tempString += temp[i];
            if(i > 0) {
                tempString += " ";
            }
        }

        return tempString;
    }

    /**
     * In a given array of Strings, find the longest common prefix.
     * [apple, application, ape] => ap
     * [apple, application, banana] => empty string
     */
    public static String longestCommonPrefix(String[] words) {

        String initialString = words[0].toLowerCase();
        String tempString = "";

        if(words.length == 0) return "";

        for (int i = 1; i < words.length; i++) {
            tempString = "";
            for (int j = 0; j < initialString.length(); j++) {
                if(initialString.charAt(j) == words[i].toLowerCase().charAt(j)) {
                    tempString += initialString.charAt(j);
                } else break;
            }
            initialString = tempString;
        }
        return tempString;
    }



}

