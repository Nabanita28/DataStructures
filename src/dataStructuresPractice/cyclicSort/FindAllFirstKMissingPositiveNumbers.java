package dataStructuresPractice.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllFirstKMissingPositiveNumbers {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }

    public static int findKthPositive(int[] arr, int k) {
        for(int i=0; i<arr.length; i++){
        while(arr[i] > 0 && arr[i] <= arr.length &&
                arr[i] != arr[arr[i]-1]){
            int temp = arr[i];
            arr[i] = arr[temp-1];
            arr[temp-1] = temp;
        }
    }

    List<Integer> result = new ArrayList<>();
    int count = 0;
    int max = 0;
        for(int i=0; i<arr.length; i++){
        if(count <= k && arr[i] != i+1){
            max = Math.max(max, arr[i]);
            result.add(i+1);
            count++;
        }
    }

        if(count < k){
        while(count <= k){
            max++;
            result.add(max);
            count++;
        }
    }
        System.out.println("max = " + max);
        result.stream().forEach(s-> System.out.print(s + " "));
        return result.get(result.size()-1);
}
}
