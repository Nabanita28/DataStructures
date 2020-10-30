package strings.mock.interviews;

public class MakeAnagrams {
    public static void main(String[] args) {
        System.out.println("Minimum number of deletions required = " + makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
    //It must return an integer representing the minimum total characters that must be deleted to make the strings anagram

    static int makeAnagram(String a, String b) {

        int[] freqCountArr1 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freqCountArr1[a.charAt(i) - 'a']++;
        }
        int[] freqCountArr2 = new int[26];
        for (int i = 0; i < b.length(); i++) {
            freqCountArr2[b.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < freqCountArr1.length; i++) {
            count = count + Math.abs(freqCountArr1[i] - freqCountArr2[i]);
        }

        return count;
    }
}
