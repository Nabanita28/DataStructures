package linkedList.mock.interviews;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String stream = "NABANITA";
        findFirstNonRepeatingCharacter(stream);
    }

    private static void findFirstNonRepeatingCharacter(String stream) {
        List<Character> dll = new ArrayList<>();
        boolean[] repeated = new boolean[256];

        for (int i=0; i<stream.length(); i++){
            char x = stream.charAt(i);
            if (!repeated[x]){
                if (!dll.contains(x)){
                    dll.add(x);
                }else {
                    repeated[x] = true;
                    dll.remove((Character)x);
                }
            }
        }
        if (dll.size() != 0)
            System.out.println("First Non-Repeating Character is : " +dll.get(0));
    }
}
