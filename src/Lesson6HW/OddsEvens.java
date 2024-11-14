package Lesson6HW;

public class OddsEvens {
    public static void main(String[] args) {
        // Write a program to find the number of even and odd integers in a given array of integers.
        int[] numbers = {1, 2, 3, 88, 3, 6, 5, 4, 8, 9, 99};
        int evensCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                evensCount++;
            }
        }

        System.out.println("There were " + evensCount + " even numbers and " + (numbers.length - evensCount) + " odd numbers");
    }
}
