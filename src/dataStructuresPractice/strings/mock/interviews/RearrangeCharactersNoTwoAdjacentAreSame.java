package dataStructuresPractice.strings.mock.interviews;

import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeCharactersNoTwoAdjacentAreSame {
    public static void main(String[] args) {
        String str = "aaabc";
        rearrangeCharactersNoTwoAdjacentAreSame(str);
    }

    //TODO - revisit

    static class Key {
        char ch;
        int freq;

        Key(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    private static void rearrangeCharactersNoTwoAdjacentAreSame(String str) {
        int capacity = str.length();
        //We use a priority queue and put all characters and ordered by their frequencies (highest frequency character at root).
        Queue<Key> queue = new PriorityQueue<>(capacity, (key1, key2) -> {
            if (key1.freq < key2.freq) {
                return 1;
            }
            if (key1.freq > key2.freq) {
                return -1;
            }
            return 0;
        });

        int[] count = new int[26];

        for (int i = 0; i < capacity; i++) {
            count[str.charAt(i) - 'a']++;
        }

        // Insert all characters with their frequencies into a priority_queue
        for (char c = 'a'; c < 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0) {
                queue.add(new Key(c, count[val]));
            }
        }

        String answer = "";

        Key prevKey = new Key('#', 0);

        while (!queue.isEmpty()) {
            Key currentKey = queue.remove();
            answer = answer + currentKey.ch;

            if (prevKey.freq > 0) {
                queue.add(prevKey);
            }

            prevKey = currentKey;
            prevKey.freq--;
        }
        if (str.length() != answer.length()) {
            System.out.println("Not Possible");
        } else {
            System.out.println(answer);
        }
    }
}
