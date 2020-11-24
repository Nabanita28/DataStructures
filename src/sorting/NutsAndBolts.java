package sorting;

import java.util.Arrays;

public class NutsAndBolts {
    public static void main(String[] args) {
        char[] nuts = new char[]{'@','#','$','%','^','&'};
        char[] bolts = {'$','%', '&', '^', '@', '#'};
        int high = nuts.length-1;
        matchingPairs(nuts, bolts, 0, high);

        for(char c : nuts){
            System.out.print(c + " ");
        }
        System.out.println();
        for(char c : bolts){
            System.out.print(c + " ");
        }
    }

    private static void matchingPairs(char[] nuts, char[] bolts, int low, int high) {

        if(low < high){
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);
            // Now using the partition of nuts choose that for bolts partition.
            partition(bolts, low, high, nuts[pivot]);

            matchingPairs(nuts, bolts, low, pivot-1);
            matchingPairs(nuts, bolts, pivot+1, high);

        }

    }

    private static int partition(char[] arr, int low, int high, char pivot) {

        int i = low - 1;
        //int pivot = arr[high];

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // swap arr[i+1] and pivot
        char temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        //return the partition;
        return i + 1;
    }
}
