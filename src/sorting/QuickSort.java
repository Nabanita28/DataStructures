package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 80, 30, 90, 40, 50, 70};
        int n = arr.length-1;
        quickSort(arr, 0, n);
        System.out.println("Quick sort : ");
        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, 0, pi-1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // swap arr[i+1] and pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        //return the partition;
        return i + 1;
    }
}
