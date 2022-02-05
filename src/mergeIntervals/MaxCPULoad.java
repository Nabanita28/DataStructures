package mergeIntervals;

import java.util.Arrays;

public class MaxCPULoad {
    public static void main(String[] args) {
        int[][] cpuLoad = {{3,2,7}, {3,7,9}, {8,3,9}};
        System.out.println(maxCPULoad(cpuLoad, 3));
    }

    private static boolean maxCPULoad(int[][] trips, int capacity) {

        int maxCPU = 0;

        int i=0;
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        while(i<trips.length-1){
            int start = Math.max(trips[i][1], trips[i+1][1]);
            int end = Math.min(trips[i][2], trips[i+1][2]);
            if(start < end){
                if(maxCPU == 0){
                    maxCPU = trips[i][0] + trips[i+1][0];
                }else{
                    maxCPU = maxCPU + trips[i+1][0];
                }

            } else{
                int cpus = Math.max(trips[i][0], trips[i+1][0]);
                maxCPU = Math.max(maxCPU, cpus);
            }
            i++;
        }
        return maxCPU == capacity;
    }
}
