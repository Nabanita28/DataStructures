package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String s = "{[(])}";
        System.out.println(isBalanced(s));
    }

    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } else{
                char x = s.charAt(i);
                switch (x){
                    case ')':
                      if (stack.pop() != '('){
                         return "NO";
                      }
                        break;
                    case '}':
                        if (stack.pop() != '{'){
                            return "NO";
                        }
                        break;
                    case ']':
                        if (stack.pop() != '['){
                            return "NO";
                        }
                        break;
                }
            }
        }
        return "YES";
    }
}
