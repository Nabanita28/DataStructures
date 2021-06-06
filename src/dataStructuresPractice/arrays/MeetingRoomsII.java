package dataStructuresPractice.arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] time_intervals = {{0, 30},
                                   {5, 10},
                                   {15, 20}};
        int[][] time_intervals2 = {{7, 10},
                                   {2, 4}};

        System.out.println(findMinNumberOfConfRoomsRequired(time_intervals2));
    }

    private static int findMinNumberOfConfRoomsRequired(int[][] time_intervals) {

        int[] time = new int[2360];

        for(int i=0; i<time_intervals.length; i++){
            time[time_intervals[i][0]]++;
            time[time_intervals[i][1]]--;
        }

        int conference_rooms = 0, ans = 0;
        for(int i=0; i<time.length; i++){
            conference_rooms = conference_rooms + time[i];
            ans = Math.max(ans, conference_rooms);
        }
        return ans;
    }
}
