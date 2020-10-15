package stack.mock.interviews;


import java.util.Stack;

public class SpecialStack extends Stack {
    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(18);
        specialStack.push(19);
        specialStack.push(29);
        specialStack.push(15);
        specialStack.push(16);

        System.out.println("Original stack : ");
        specialStack.stream().forEach(s-> System.out.print(s + " "));
        System.out.println();
        System.out.println("Min stack : ");
        minStack.stream().forEach(s-> System.out.print(s + " "));

        System.out.println("Get min: " + specialStack.getMin());
        System.out.println("Pop :  " + specialStack.pop());
        System.out.println("Pop : " + specialStack.pop());
        System.out.println("Get min : " + specialStack.getMin());

        specialStack.stream().forEach(s-> System.out.print(s + " "));
        System.out.println();
        System.out.println("Min stack : ");
        minStack.stream().forEach(s-> System.out.print(s + " "));
    }
    static Stack<Integer> minStack = new Stack<>();
    void push(int x){
        if (isEmpty()) {
            super.push(x);
            minStack.push(x);
        }
            else{
                super.push(x);
                int y = minStack.peek();
                if (x < y)
                    minStack.push(x);
                else
                    minStack.push(y);
        }
    }

    public Integer pop()
    {
        minStack.pop();
        return (int) super.pop();
    }

    int getMin(){
        return minStack.peek();
    }
}
