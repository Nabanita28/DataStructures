package stack;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
    }

    private static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);

            if(Character.isLetterOrDigit(c)) {
                result += c;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')'){
                while(!stack.isEmpty() && '(' != stack.peek()){
                    result += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                stack.pop();

            }
            else{
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if ('(' == stack.peek()) return "invalid expression";
            result += stack.pop();
        }
        return result;

    }

    private static int precedence(int n){
        switch (n){
            case '+' :
            case '-' :
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
