package dataStructuresPractice.arrays.mustDo;

import java.util.*;

public class MergeKsSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        List<Integer> result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 }, 3);
        System.out.println(Arrays.toString(new List[]{result}));
    }
    public static ArrayList<Integer> mergeKSortedArray(int[][] arr, int K)
    {
        Queue<ArrayContainer> minHeap = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            minHeap.add(new ArrayContainer(arr[i], 0));
        }

        ArrayList<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty()){
            ArrayContainer ac = minHeap.poll();

            result.add(ac.array[ac.index]);

            if(ac.index < ac.array.length-1) {
                ac.index = ac.index + 1;
                minHeap.add(ac);
            }

        }
        return result;

    }

    static class ArrayContainer implements Comparable<ArrayContainer>{
        int index;
        int[] array;

        ArrayContainer(int[] array, int index){
            this.index = index;
            this.array = array;
        }

        @Override
        public int compareTo(ArrayContainer arrayContainer){
            return this.array[this.index] - arrayContainer.array[arrayContainer.index];
        }
    }
}
