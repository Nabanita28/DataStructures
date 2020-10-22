package general.mock.interviews;

public class WaterJugProblem {
    public static void main(String[] args) {
        System.out.println(findMinSteps(3, 5, 4));
    }

    private static int findMinSteps(int m, int n, int d) {
        // To make sure that m is smaller than n
        if (m > n) {
            swap(m, n);
        }
        // If gcd of n and m does not divide d then solution is not possible
        if ((d % gcd(m, n)) != 0) {
            return -1;
        } else {
            // Return minimum two cases:
            // a) Water of n liter jug is poured into
            //    m liter jug
            // b) Vice versa of "a"
            return Math.min(pour(n, m, d), pour(m, n, d));
        }
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    /* fromCap -- Capacity of jug from which
              water is poured
   toCap   -- Capacity of jug to which
              water is poured
   d       -- Amount to be measured */
    private static int pour(int fromCap, int toCap, int d) {
        // Initialize current amount of water
        // in source and destination jugs
        int from = fromCap;
        int to = 0;
        // Initialize count of steps required
        int steps = 1;

        while(from != d && to != d){

            int temp = Math.min(from, toCap-to);

            to = to + temp;
            from = from - temp;

            steps++;

            if (from == d || to == d){
                break;
            }
            if (from == 0) {
                from = fromCap;
                steps++;
            }
            if (to == toCap){
                to = 0;
                steps++;
            }
        }
        return steps;
    }


    private static void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }
}
