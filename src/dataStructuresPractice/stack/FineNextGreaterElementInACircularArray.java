package dataStructuresPractice.stack;

public class FineNextGreaterElementInACircularArray {

    public static void main(String[] args) {
        int[] result = nextGreaterElements(new int[]{4, -2, 9, 8});
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
    public static int[] nextGreaterElements(int[] nums) {

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int size = nums.length;

        int[] result = new int[size];

        for(int i=0; i<size; i++){
            result[i] = -1;
        }
        int i = 0;
        while(i < 2*size){

            while(!stack.isEmpty() && nums[i%size] > nums[stack.peek()]){
                result[stack.peek()] = nums[i%size];
                stack.pop();
            }
            stack.push(i%size);
            i++;
        }
        return result;
    }
}
