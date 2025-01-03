package Lesson17XmasHW;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        WordSuggestion test = new WordSuggestion();
        test.update("there", "Hello");
        test.update("World", "hello");
        test.update("World", "hello");
        test.update("World", "hello");
        test.update("Darcy", "Hello");
        test.update("banana", "Hello");
        test.update("banana", "hello");
        test.update("World", "hello");
        test.update("james", "hello");
        test.update("apple", "Hello");
        System.out.println(test);

        System.out.println(Arrays.toString(test.mostUsedWords("hello", 100).toArray()));

    }
}
