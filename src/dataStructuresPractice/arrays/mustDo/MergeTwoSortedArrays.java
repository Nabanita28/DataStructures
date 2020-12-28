package dataStructuresPractice.arrays.mustDo;

public class MergeTwoSortedArrays {
    public static void main(String[] args){
        int[] arr1 = new int[]{10, 27, 38, 43 ,82 };
        int[] arr2 = new int[]{3,9};
        mergeSortedArrays(arr1,arr2);
    }

    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n+m];
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i < n && j < m)
        {
            /*Check if current element of first array is smaller than current element
            of second array. If yes, store first array element and increment first array
            index. Otherwise do same with second array*/
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < m)
            arr3[k++] = arr2[j++];

        //print the final array
        System.out.println("Array after merging");
        for (int p=0; p < n+m; p++)
            System.out.print(arr3[p] + " ");
    }
}
