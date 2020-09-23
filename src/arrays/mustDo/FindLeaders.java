package arrays.mustDo;

public class FindLeaders {
    public static void main(String[] args) {
        int[] arr = new int[]{16, 17, 4, 3, 5, 2};
        findLeadersInArray(arr);
    }

    // time complexity is O(n*n)
    private static void findLeaders(int[] arr) {
        System.out.print("Leaders in the given array are : " + arr[arr.length - 1]);
        int i, j = 0;
        for (i = 0; i < arr.length - 2; i++) {
            j = arr.length - 2;

            while (arr[i] > arr[j]) {
                j--;
            }
            if (arr[i] < arr[j]) {
                continue;
            }
            System.out.print(" " + arr[i]);
        }

        if (i == j && arr[i] > arr[arr.length - 1]) {
            System.out.print(" " + arr[i]);
        }
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
