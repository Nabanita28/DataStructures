package general.mock.interviews;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 6, 5};

        System.out.println(checkPythagoreanTriplet(arr));
    }

    //Time Complexity: O( max * max ), where max is the maximum most element in the array.
    private static boolean checkPythagoreanTriplet(int[] arr) {

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] hash = new int[max + 1];

        for (int i = 0; i < arr.length; i++)
            hash[arr[i]]++;

        for (int a = 1; a < max + 1; a++) {

            if (hash[a] == 0)
                continue;

            for (int b = 1; b < max + 1; b++) {

                //if a & b are same, b doesn't exist
                if (a == b && (hash[a] == 1 || hash[b] == 0))
                    continue;

                //find c
                int c = (int) Math.sqrt(a * a + b * b);

                if (a * a + b * b != c * c)
                    continue;

                // If c exceeds the maximum value
                if (c > max)
                    continue;
                // If there exists c in the original array, we have the triplet
                if (hash[c] == 1)
                    return true;
            }
        }
        return false;
    }
}

