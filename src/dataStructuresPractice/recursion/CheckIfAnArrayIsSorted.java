package dataStructuresPractice.recursion;

public class CheckIfAnArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {2,4,6,1};
        System.out.println(checkIfSorted(arr, 0));
    }

    private static boolean checkIfSorted(int[] arr, int index) {

        //base case
        if(index == arr.length-1){
            return true;
        }
        if(arr[index] > arr[index+1]){
            return false;
        } else
            return checkIfSorted(arr, index+1);
    }
}
