package dataStructuresPractice.arrays.mustDo;

public class ArrangeZigZag {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,7,8,6,2,1};
        arrangeZigZag(arr);
    }

    private static void arrangeZigZag(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isNextDecreasing = arr[i] > arr[i+1];
            boolean isEven = i%2 ==0;
            //

            if (isEven ^ isNextDecreasing) {
                swap(arr, i);
            }

            //

           /* if (isEven && isNextDecreasing) {
                continue;
            }
            else if (!isEven && !isNextDecreasing) {
                continue;
            } else {
                swap(arr, i);
            }*/
        }
        for (int k : arr)
            System.out.print(k + " ");
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

}
