package stack.mock.interviews;

import java.util.Stack;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] towers = new int[]{11, 13, 21, 3};
        findNextGreaterNumber(towers);
    }

    private static void findNextGreaterNumber(int[] towers) {
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(towers[0]);

        for(int i=1; i<towers.length; i++){
            while (!stack.isEmpty() && stack.peek() <= towers[i]){
                stack.pop();
                sum = sum + towers[i];
            }
            stack.push(towers[i]);
        }

        while(!stack.isEmpty()){
            stack.pop();
            sum = sum - 1;
        }

        System.out.println(sum);
    }
}
