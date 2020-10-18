package arrays;

import java.util.Arrays;

public class ValleyCount {
    public static void main(String[] args) {
        String s = "UDDDUDUU";
        System.out.println("Valley count = " + (countingValleys(s.length(), s)));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here

        char[] hike = path.toCharArray();
        int[] count = new int[steps];

        int countOfD = 0;
        for (int i = 0; i < steps; i++) {

            if (hike[i] == 'D') {
                countOfD--;
                count[i] = countOfD;
            }
            else if (hike[i] == 'U') {
                countOfD++;
                count[i] = countOfD;
            }
        }

        int valleyCount = 0;

        for (int i = 0; i < steps; i++) {
            if (count[i] < 0) {
                valleyCount++;
                while (count[i] < 0 && i<steps) {
                    i++;
                }
            }
        }
        return valleyCount;
    }
}
