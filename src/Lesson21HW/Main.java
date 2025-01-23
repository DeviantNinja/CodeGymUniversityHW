package Lesson21HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkBrackets("()()()[]{{[]}}"));
        System.out.println(checkBrackets("((])[)"));
        System.out.println(checkBrackets("((({}{[]})))"));
        System.out.println(checkBrackets(")("));
        System.out.println(checkBrackets(""));
    }

    public static String removePairsOfAdjacentLetters(String string){
        return "";
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


