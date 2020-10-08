package arrays.mustDo;

public class NumberOfTrainPlatforms {
    public static void main(String[] args) {
        int[] arrival = new int[]{900,  940, 950,  1100, 1500, 1800};
        int[] departure = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findNumberOfTrainPlatformsRequired(arrival, departure));
    }

    private static int findNumberOfTrainPlatformsRequired(int[] arrival, int[] departure) {
        int n = arrival.length;
        int[] platform = new int[2360];

        for (int i=0; i<n; i++){
            platform[arrival[i]]++;
            platform[departure[i]]--;
        }
        int max_platform_count = 0;
        int platform_sum = 0;
        for (int j=0; j<platform.length; j++){
            platform_sum += platform[j];
            max_platform_count = Math.max(platform_sum, max_platform_count);
        }

        return max_platform_count;
    }
}
