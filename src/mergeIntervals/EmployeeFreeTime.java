package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFreeTime {
    public static void main(String[] args) {
        int[][][] intervals = {{{1,3}, {9,12}},
                               {{2, 4}, {6, 8}}};
        findFreeInterval(intervals).stream().forEach(item-> System.out.println(item[0] + " " + item[1]));
    }

    private static List<int[]> findFreeInterval(int[][][] intervals) {

        int[] workingHours = new int[1001];
        int maxWorkingHourTillNow = 0;

        for(int[][] employee : intervals){
            for(int[] time : employee) {
                maxWorkingHourTillNow = Math.max(time[1], maxWorkingHourTillNow);
                workingHours[time[0]]++;
                workingHours[time[1]]--;
            }
        }

        List<int[]> result = new ArrayList<>();
        int count = workingHours[0];
        int start;
        int end;

        for(int i=1; i< maxWorkingHourTillNow; i++){

            count = count + workingHours[i];

            if(count == 0){
                start = i;
                while(i < workingHours.length-1 && count == 0){
                    i++;
                    count = count + workingHours[i];
                }
                end = i;
                result.add(new int[]{start, end});
            }
        }

        return result;
    }

}
