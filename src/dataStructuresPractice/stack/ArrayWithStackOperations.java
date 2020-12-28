package dataStructuresPractice.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayWithStackOperations {
    public static void main(String[] args) {
        int[] arr = {1,3};
        System.out.println(buildArray(arr, 3));
    }
    public static List<String> buildArray(int[] target, int n) {

        int j=0;
        List<String> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if( j<target.length && target[j] == i ){
                list.add("PUSH");
                j++;
            }else{
                list.add("PUSH");
                list.add("POP");
            }
        }
        return list;
    }
}
