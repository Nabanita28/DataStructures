package dataStructuresPractice.stack;

public class PostFixExpression {
    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }

    private static int evaluatePostfix(String exp) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        String[] charArr = exp.split(" ");
        System.out.println(charArr);
        for (int i = 0; i < charArr.length; i++) {
            String str = charArr[i];
            if (charArr[i].chars().allMatch(Character::isDigit)) {
                stack.push(Integer.parseInt(charArr[i]));
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (str) {
                    case "+":
                        stack.push(val2 + val1);
                        break;

                    case "-":
                        stack.push(val2 - val1);
                        break;

                    case "/":
                        stack.push(val2 / val1);
                        break;

                    case "*":
                        stack.push(val2 * val1);
                        break;
                }
            }
        }


        return stack.pop();
    }
}
