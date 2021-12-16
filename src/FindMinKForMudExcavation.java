import java.util.*;

public class FindMinKForMudExcavation {
    public static void main(String[] args) {
        List<Integer> mudValues = new ArrayList<>(Arrays.asList(3, 6, 7, 11));
        int hours = 8;
        System.out.println("Minimum K value = " + findMinKForMudExcavation(mudValues, hours));

    }

    private static int findMinKForMudExcavation(List<Integer> mudValues, int h) {

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < mudValues.size(); i++) {
            minHeap.add(mudValues.get(i));
        }
        int hours = h;
        int k = 0;
        int minK = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        boolean breakFlag = false;

        while (minHeap.size() > 0) {

            if(breakFlag){
                break;
            }
            if(minK == Integer.MAX_VALUE){
                k = minHeap.remove();
                set.add(k);
            }
            int i = 0;


            while (i < mudValues.size() && hours >= 0) {
                int mud = mudValues.get(i);
                if (mud % k == 0) {
                    int time = mud / k;
                    hours = hours - time;
                } else {
                    double time = (double) mud / k;
                    hours = hours - (int) Math.ceil(time);
                }
                if (hours < 0) {
                    i = 0;
                    hours = h;
                    break;
                }
                i++;

                if(i == mudValues.size()){
                    minK = Math.min(minK, k);
                    k--;
                    if(set.contains(k)){
                        breakFlag = true;
                        break;
                    }
                    set.add(k);
                    hours = h;
                }
            }

        }
        return minK;
    }

}
