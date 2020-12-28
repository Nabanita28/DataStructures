package dataStructuresPractice.strings.mock.interviews;

public class MinimumAdditionsForBalancedString {
    public static void main(String[] args) {
        String s = "nabanita";
        findMinimumAdditionsRequiredForBalancedString(s);
    }

    private static void findMinimumAdditionsRequiredForBalancedString(String s) {

        int[] freq = new int[26];

        for (int i=0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int max_freq = maximumFreq(freq);
        int minimumAdditions = 0;

        for (int k=0; k<freq.length; k++){
            if (freq[k] > 0)
            minimumAdditions = minimumAdditions + Math.abs(max_freq - freq[k]);
        }
        System.out.println("Minimum Additions Required For making a string Balanced is : " + minimumAdditions);
    }

    private static int maximumFreq(int[] freq) {
        int max_freq = 0;

        for (int j=0; j<freq.length; j++){
            if (freq[j] > max_freq)
                max_freq = freq[j];
        }
        return max_freq;
    }
}
