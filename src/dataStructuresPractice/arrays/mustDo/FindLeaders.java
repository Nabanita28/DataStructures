package dataStructuresPractice.arrays.mustDo;

public class FindLeaders {

    //Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side.
    // And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
    public static void main(String[] args) {
        int[] arr = new int[]{16, 17, 4, 3, 5, 2};
        findLeadersInArray(arr);
    }

    //time complexity is O(n)
    private static void findLeadersInArray(int[] arr){
        int max = arr[arr.length-1];
        System.out.println(max);
        for (int i=arr.length-2; i>0; i--){
            if (max < arr[i]){
                max = arr[i];
                System.out.println(max);
            }
        }

    }
}
