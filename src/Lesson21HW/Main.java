package Lesson21HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkBrackets("()()()[]{{[]}}")); //true
        System.out.println(checkBrackets("((])[)")); //false
        System.out.println(checkBrackets("((({}{[]})))")); //true
        System.out.println(checkBrackets(")(")); //false
        System.out.println(checkBrackets("")); //false


        System.out.println(removePairsOfAdjacentLetters("afghhgfdds")); //as
        System.out.println(removePairsOfAdjacentLetters("xdaabbccdy")); //xy
    }

    public static String removePairsOfAdjacentLetters(String string){
        Stack<Character> stack = new Stack<>();
        String modifiedString = "";

        for(char c : string.toCharArray()){
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(stack.peek() == c){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        for(char c : stack){
            modifiedString += c;
        }


        return modifiedString;
    }

    public static boolean checkBrackets(String input){
        if (input.isEmpty() || input.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put('}','{');
        brackets.put(']','[');
        brackets.put(')','(');

        for(char c : input.toCharArray()) {
            if(brackets.containsValue(c)) {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                if(stack.peek() == brackets.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}


