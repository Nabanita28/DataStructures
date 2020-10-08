package arrays.mustDo;

public class Sort0s1s2s {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort0s1s2s(arr);
    }

    private static void sort0s1s2s(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        int temp = 0;

        while(mid <= high){

            switch(arr[mid]){
                case 0 :
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1 :
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }

        for (int k : arr)
            System.out.print(k + " ");
    }
}
