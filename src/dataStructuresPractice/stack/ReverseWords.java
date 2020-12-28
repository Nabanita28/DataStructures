package dataStructuresPractice.stack;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "Nabanita Majumder";
        reverseWords(s);

    }

    private static void reverseWords(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
