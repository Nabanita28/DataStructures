package arrays.mockInterviews;

public class RangeUpdatesAndPointQueries {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int l = 3;
        int r = 4;
        int val = 2;
        int index = 3;
        update(0,4,2, arr);
        System.out.println("Index at " + index + " is : " + getElement(index, arr));
    }

    private static int getElement(int index, int[] arr) {
        int res = 0;
        for (int j=0; j<index; j++){
            res = res + arr[j];
        }
        return res;
    }

    private static void update(int l, int r, int val, int[] arr) {
        arr[l] = arr[l] + val;
        if (r+1 < arr.length)
            arr[r+1] = arr[r+1] - val;
    }
}
