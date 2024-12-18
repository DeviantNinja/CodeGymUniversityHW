package Lesson15HWand16HW;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        fill(list);

        /*
        Write a method to return n-th to the last element in a singly linked list
        (i.e. in the list: 1,2,3,4,5,6,7,8,9,10, with n = 3, return 8, n = 2, return 9). .  (edited)
         */
        System.out.println(list.getNthFromLastOnePass(2).data); //Harder solution: Try it without going twice, only once.
        System.out.println(list.getNthFromLast(2).data); //First solution: go thru list twice

        String string = "as!d123ad%jsk2358 Akja9sd"; // 1 + 2 + 3 + 2 + 3 + 5 + 8 + 9 = 33
        System.out.println(addDigitsInString(string));

        // Find the intersection of 2 arrays.
        // Find the union of 2 arrays.
        // [1,2,3,4,5,6,7,8,9] and [7,8,9,10,11,12,13,14]

        int[] list1 = {1,2,3,4,5,6,7,8,9};
        int[] list2 = {7,8,9,10,11,12,13,14};

        System.out.println(findUnion(list1, list2));
        System.out.println(findIntersection(list1, list2));
    }

    /*
    Given a string that has mixed letters and numbers
    (e.g. "as!d123ad%jsk2358 Akja9sd"), return the sum of all
    the digits in that string, ignoring every other non-numerical character.
     */
    public static int addDigitsInString(String string){
        int total = 0;

        for(char c : string.toCharArray()) {
            if(Character.isDigit(c)){
                total += c - '0';
            }
        }
        return total;
    }

    public static Set<Integer> findUnion(int[] array1, int[] array2) {
        Set<Integer> arrayUnion = new HashSet<>();

        for (Integer i : array1) {
            arrayUnion.add(i);
        }

        for (Integer i : array2) {
            arrayUnion.add(i);
        }

        return arrayUnion;
    }

    public static Set<Integer> findIntersection(int[] array1, int[] array2) {
        Set<Integer> arraySet = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (Integer i : array1) {
            arraySet.add(i);
        }

        for(int i : array2){
            if(arraySet.contains(i)) {
                intersection.add(i);
            }
        }

        return intersection;
    }

    private static void fill(MyLinkedList<Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
    }

}
