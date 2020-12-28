package dataStructuresPractice.stack;
import java.util.Stack;
public class DeleteStackElements {
    dataStructuresPractice.stack.Stack.StackNode top;

    public static void main(String[] args) {
        int[] arr = new int[]{23,45,11,77,18};

        deleteElements(arr, 3);
    }

    private static void deleteElements(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        int count = 0;
        for(int i=1; i<arr.length; i++){
            while(!stack.isEmpty() && stack.peek()<arr[i] && count<k){
                stack.pop();
                count++;
            }
            stack.push(arr[i]);
        }

        System.out.println(stack);


        }
    }


