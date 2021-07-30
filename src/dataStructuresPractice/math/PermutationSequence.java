package dataStructuresPractice.math;

import java.util.LinkedList;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 4));
    }

    public static String getPermutation(int n, int k) {
        LinkedList<Integer> notUsed = new LinkedList<>();

        int weight = 1;

        for (int i = 1; i <= n; i++) {
            notUsed.add(i);
            if (i == n)
                break;
            weight = weight * i;
        }

        String res = "";
        k = k - 1;
        while (true) {
            res = res + notUsed.remove(k / weight);
            k = k % weight;
            if (notUsed.isEmpty())
                break;
            weight = weight / notUsed.size();
        }

        return res;
    }
}