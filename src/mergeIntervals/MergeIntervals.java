package mergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

    }

    static public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int i=0; i<intervals.length; i++){

            int lastEnd = merged.getLast()[1];
            int currentStart = intervals[i][0];

            if(merged.isEmpty() || lastEnd < currentStart){
                merged.add(intervals[i]);
            }else{
                lastEnd = Math.max(lastEnd, intervals[i][1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
