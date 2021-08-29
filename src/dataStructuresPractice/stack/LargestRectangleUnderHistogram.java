package dataStructuresPractice.stack;

public class LargestRectangleUnderHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleUnderHistogram(new int[]{6, 2, 5, 4, 5, 1, 6}));
    }

    static int largestRectangleUnderHistogram(int[] values){
        int maxArea = values[0];
        int size = values.length;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(-1);
        int[] left = new int[size];
        int[] right = new int[size];

        for(int i=0; i<size; i++){
            left[i] = -1;
            right[i] = size;
        }
        int i=0;

        while(i < size){
            //right
            while(!stack.isEmpty() && stack.peek() != -1 && values[i]< values[stack.peek()]){
                right[stack.peek()] = i;
                stack.pop();
            }
            //equal
            if(i>0 && values[i] == values[i-1]){
                left[i] = left[i-1];
            }
            else{
                left[i] = stack.peek();
            }
            stack.push(i);
            i++;
        }

        //calculate max
        for(int k=0; k<size; k++){
            maxArea = Math.max(maxArea, values[k]*(right[k] - left[k] - 1));
        }
        return maxArea;

    }
}
