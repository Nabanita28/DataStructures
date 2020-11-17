package arrays.mockInterviews;

public class NumberOfOccurences {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,2,3};
        System.out.println(count(arr, arr.length, 2));
    }

    static int count(int[] arr, int n, int x) {

        int i=0; int j=0;

        i = first(arr, 0, n-1, x, n);

        if(i == -1)
            return -1;

        j = last(arr, i, n-1, x, n);


        return (j - i + 1);

    }

    static int first(int[] arr, int low, int high, int x, int n){


        if(high >= low){

            int mid = (low + high)/2;

            if((mid == 0 || x > arr[mid-1]) && arr[mid] == x){
                return mid;
            }

            if(x <= arr[mid]){
                return first(arr, low, mid-1, x, n);
            } else{
                return first(arr, mid+1, high, x, n);
            }

        }

        return -1;

    }


    static int last(int[] arr, int low, int high, int x, int n){

        if(high >= low){

            int mid = (low+high)/2;

            if((mid == n-1 || x < arr[mid+1]) && arr[mid] == x){
                return mid;
            }

            if(x < arr[mid]){
                return  last(arr, low, mid-1, x, n);
            } else{
                return last(arr, mid+1, high, x, n);
            }


        }

        return -1;
    }
}
