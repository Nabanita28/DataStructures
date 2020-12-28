package dataStructuresPractice.stack;

public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        while (top != null) {
            System.out.println(stack.pop());
        }
    }
    private static StackNode top;
    static class StackNode{
        int data;
        StackNode next;

        public StackNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void push(int item){
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
    }

    public static int pop(){
        if(top.data == -1){
            return -1;
        }
        int item = top.data;
        top = top.next;
        return item;
    }

    public static int peek(){
        if(top == null) return -1;
        return top.data;
    }

    public static boolean isEmpty(){
        return top == null;
    }
}
