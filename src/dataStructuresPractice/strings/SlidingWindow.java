package dataStructuresPractice.strings;

public class SlidingWindow {



    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.print("-->Smallest window that contain all character : ");
        System.out.println(minimumWindow(s.toCharArray(), t.toCharArray()));

    }

    private static String minimumWindow(char[] text, char[] pattern) {
        int[] hasFound = new int[256];
        int count = 0;
        int answer = Integer.MAX_VALUE;
        int start = 0;

        for(int i=0; i<pattern.length; i++){
            if(hasFound[pattern[i]]== 0){
                count++;
            }
            hasFound[pattern[i]]++;
        }
        int i=0, j=0;

        while(j < text.length){
            hasFound[text[j]]--;

            if(hasFound[text[j]] == 0){
                count--;
            }
            if (count == 0){
                while(count == 0){
                    if (answer > j-i+1){
                        answer = Math.min(answer,j-i+1);
                        start = i;
                    }
                    hasFound[text[i]]++;
                    if (hasFound[text[i]] > 0){
                        count++;
                    }
                    i++;
                }
            }
            j++;
        }
        if (answer != Integer.MAX_VALUE){
            return String.valueOf(text).substring(start, start+answer);
        }else{
            return "Not found";
        }
    }
}
