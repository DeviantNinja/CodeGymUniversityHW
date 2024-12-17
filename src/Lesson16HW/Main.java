package Lesson16HW;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String string = "as!d123ad%jsk2358 Akja9sd";
        System.out.println(addDigitsInString(string));

        LinkedList<Integer> list = new LinkedList<>();
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
        System.out.println(list.size());
        System.out.println(NthToLastValue(list,0));

    }

    public static int addDigitsInString(String string){
        int total = 0;

        for(char c : string.toCharArray()) {
            if(Character.isDigit(c)){
                total += c - '0';
            }
        }
        return total;
    }

    public static int NthToLastValue(LinkedList<Integer> list, int nthValue){
        int count = 0;
        for (Integer integer : list) {
            count++;
        }
        return list.get(count - nthValue);
    }


}

//Given a string that has mixed letters and numbers
// (e.g. "as!d123ad%jsk2358 Akja9sd"),
// return the sum of all the digits in that string,
// ignoring every other non-numerical character.

//Write a method to return n-th to the last element in a singly linked list
// (i.e. in the list: 1,2,3,4,5,6,7,8,9,10, with n = 3, return 8, n = 2, return 9).
// First solution: go thru list twice.
// Harder solution: Try it without going twice, only once. (edited)

