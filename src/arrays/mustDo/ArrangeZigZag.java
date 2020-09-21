package arrays.mustDo;

public class ArrangeZigZag {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,7,8,6,2,1};
        arrangeZigZag(arr);
    }

    private static void arrangeZigZag(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (isEven(i) && arr[i] > arr[i + 1]) {
                continue;
            }
            else if (isOdd(i) && arr[i] < arr[i + 1]) {
                continue;
            } else {
                swap(arr, i);
            }
        }
        for (int k : arr)
            System.out.print(k + " ");
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    private static boolean isEven(int i) {
        return (i % 2 == 0);
    }

    private static boolean isOdd(int i) {
        return !isEven(i);
    }
}
