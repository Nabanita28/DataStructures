package dataStructuresPractice.arrays.mockInterviews;

public class NumberOfSwapsQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6, 7};
        System.out.println("count = " + minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {

        int low = 0;
        int high = arr.length -1;
        sort(arr, low, high);
        return count-1;

    }

    static int count = 0;
    static void sort(int[] arr, int low, int high){

        if(low<high){
            int partitionIndex = partition(arr, low, high);

            sort(arr, low, partitionIndex-1);
            sort(arr, partitionIndex+1, high);
        }
    }

    static int partition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i= (low-1);
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[i] = temp;
                count++;
            }
        }
        int temp = arr[i+ 1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        count++;
        return i+1;

    }
}
