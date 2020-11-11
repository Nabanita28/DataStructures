package strings.mock.interviews;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println("First Non-Repeating Character is at index - " + firstUniqueChar(s));
    }

    public static int firstUniqueChar(String s) {

        if(s.length() == 0){
            return -1;
        }

        createCountIndexHashMap(s);

        int result = Integer.MAX_VALUE;
        boolean flag = false;

        for(Map.Entry<Character, CountIndex> entry : map.entrySet()){

            int ind = entry.getValue().index;
            int count = entry.getValue().count;
            for(int i=0, j=0; i<26 && j<26; i++,j++){

            }
            if(count == 1 && ind < result){
                result = ind;
                flag = true;
            }
        }

        return flag ? result : -1;

    }


    static Map<Character, CountIndex> map = new HashMap<>();

    public static void createCountIndexHashMap(String str){

        for(int i=0; i<str.length(); i++){
            char item = str.charAt(i);
            if(map.containsKey(item)){
                map.get(item).incCount();
            }
            else{
                map.put(item, new CountIndex(i));
            }
        }
    }

    static class CountIndex{
        int index;
        int count;

        public CountIndex(int index){
            this.index = index;
            this.count = 1;
        }

        public void incCount(){
            this.count++;
        }
    }
}
