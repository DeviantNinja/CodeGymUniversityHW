package Lesson6HW;

import java.util.Scanner;

public class FindIndex {
    /*
        Not sure if this was supposed to find the first location or all locations.
        All locations found are printed in the below code. this could be simply amended
        by adding a break after the numberFound if you only wanted the first position.
     */
    public static void main(String[] args) {
        // Write a program to find the index of an array element. (-1 if not found)
        int[] numbers = {1, 2, 3, 88, 3, 6, 5, 4, 8, 9, 99};
        int numberToFind;
        boolean numberFound = false;

        //assumes correct input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Find Number: ");
        numberToFind = scanner.nextInt();

        for (int i = 0; i < numbers.length; i++) {
            if(numberToFind == numbers[i]) {
                System.out.println(i);
                numberFound = true;
            }
        }

        if(!numberFound){
            System.out.println(-1);
        }

    }
}


