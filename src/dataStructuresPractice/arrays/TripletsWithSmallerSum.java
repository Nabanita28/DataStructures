package dataStructuresPractice.arrays;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        long[] arr = {5, 1, 3, 4, 7 };
        System.out.println(countTriplets(arr, arr.length, 12));
    }

   static long countTriplets(long arr[], int n,int sum)
    {
        long countOfTriplets = 0l;
        long currentSum = 0;
        Arrays.sort(arr);

        for(int i = 0; i < n-2; i++){
            int j = i+1;
            int k = n-1;

            while(j < k){

                currentSum = arr[i] + arr[j] + arr[k];

                if(currentSum >= sum){
                    k--;
                } else{
                    countOfTriplets = countOfTriplets + (k-j);
                    j++;
                }
            }
        }
        return countOfTriplets;
    }
}
