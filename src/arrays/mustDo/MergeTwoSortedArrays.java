package arrays.mustDo;

public class MergeTwoSortedArrays {
    public static void main(String[] args){
        int[] arr1 = new int[]{10, 27, 38, 43 ,82 };
        int[] arr2 = new int[]{3,9};
        mergeSortedArrays(arr1,arr2);
    }
    //TODO need to re-visit

    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int gap = arr1Length + arr2Length;
        int i, j = 0;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            //check first array
            for (i = 0; i + gap < arr1Length; i++) {
                //swap
                if (arr1[i] > arr1[i+gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }
            //check both array
            for (j = gap > arr1Length ? gap - arr1Length : 0; j < arr2Length && i < arr1.length; i++, j++) {
                //swap
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if (j < arr2Length) {
                for (j = 0; j + gap < arr2Length; j++) {
                    //swap
                    if (arr2[j] > arr2[j+gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[gap + j];
                        arr2[gap + j] = temp;
                    }
                }
            }
        }

        //print sorted arrays
        System.out.print("First Array: ");
        for (int arr1Num : arr1)
            System.out.print(arr1Num + " ");

        System.out.println();
        System.out.print("Second Array: ");

        for (int arr2Num : arr2)
            System.out.print(arr2Num + " ");
    }

    private static int nextGap(int gap) {
        if (gap<=1)
            return 0;

        return (gap/2) + (gap%2);
    }

}
