package dataStructuresPractice.stack.mustDo;

import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        System.out.println("Is the given expression String Balanced - " + checkIfBalanced("[()]{}{[()()]()}"));
    }

    private static boolean checkIfBalanced(String s) {
        int count = 0;
        Stack<Character> stack = new java.util.Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                count++;
            }

            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (!stack.isEmpty())
                    stack.pop();
                count--;
            }
        }

        if (count == 0)
            return true;
        else
            return false;
    }
}