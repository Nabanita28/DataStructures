package mergeIntervals;

public class MinimumMeetingRoomRequired {
    public static void main(String[] args) {
        int[][] meetings = {{0, 5}, {5, 9}, {10, 20}} ;
        System.out.println(minimumMeetingRoomRequired(meetings));
    }

    static int MAX = 100001;

    private static int minimumMeetingRoomRequired(int[][] meetings) {

        int[] prefixSum = new int[MAX];

        for(int i=0; i<meetings.length; i++){
            prefixSum[meetings[i][0]]++;
            prefixSum[meetings[i][1]]--;
        }

        int count = prefixSum[0];

        for(int i=1; i<MAX; i++){
            prefixSum[i] = prefixSum[i] + prefixSum[i-1];
            count = Math.max(count, prefixSum[i]);
        }
        return count;
    }
}
