package algoProblems.arrays;

import java.util.Stack;

public class ProductSumWithVaryingDepth {

    public static void main(String[] args) {
//        int[][] inp = {5, 2, {7,-1}, 3, {6, {-13, 8}, 4}};
        //             5+2 + 2*(7-1) + 3 + 2*(6 + 3*(-13+8) + 4)
        //            7 + 12 + 3 + 2*(6 - 15 +4)
        //            22 - 10
        //       12


        String inputString = "[,5,2,[,7,-1,],3,[,6,[,-13,8,],4,],]";

        String[] strArr = inputString.split(",");
        System.out.println(calculateProductSum(strArr));

    }

    private static int calculateProductSum(String[] strArr) {

        Stack<Integer> stack = new Stack<>();
        int depth = 0;
        boolean newEntry = false;
        for (int i = 0; i < strArr.length; i++) {

            if (strArr[i].equals("[")) {
                depth++;
                newEntry = true;

            } else if (strArr[i].equals("]")) {
                if (stack.size() >= 2) {
                    int last = stack.pop();
                    int secondLast = stack.pop();
                    stack.push(last * depth + secondLast);
                }
                depth--;

            } else {
                int num = Integer.parseInt(strArr[i]);
                if (newEntry) {
                    stack.push(num);
                } else {
                    int poppedNum = stack.pop();
                    stack.push(poppedNum + num);
                }
                newEntry = false;
            }
        }

        return stack.pop();
    }
}
