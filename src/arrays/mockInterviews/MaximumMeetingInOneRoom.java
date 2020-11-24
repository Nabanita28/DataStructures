package arrays.mockInterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumMeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        List<Meeting> meetings = new ArrayList<>();
        for (int i=0; i<start.length; i++){
            meetings.add(new Meeting(start[i], end[i], i));
        }

        maxMeetings(meetings);

    }

    private static void maxMeetings(List<Meeting> meetings) {
        SortMeetings sortMeetings = new SortMeetings();
        Collections.sort(meetings, sortMeetings);

        List<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).pos);
        int time_limit = meetings.get(0).end;
        int count = 0;
        for(int i=1; i<meetings.size(); i++){
            if(meetings.get(i).start > time_limit){
                answer.add(meetings.get(i).pos);
                time_limit = meetings.get(i).end;
                count++;
            }
        }

        answer.stream().forEach(s-> System.out.print((s+1) + " "));
        System.out.println("Maximum number of meetings possible = " + (count+1));
    }

    static class SortMeetings implements Comparator<Meeting> {

        @Override
        public int compare(Meeting m1, Meeting m2){
          if (m1.end < m2.end){
              return -1;
          }
          if (m1.end > m2.end){
              return 1;
          }
          return 0;
      }
    }

    static class Meeting{
        int start;
        int end;
        int pos;

        public Meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }
}
