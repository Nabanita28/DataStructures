package general;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(5));
    }

    private static double findSquareRoot(double num) {

        return sqrtUtil(0, num, num);
    }

    private static double sqrtUtil(double left, double right, double x) {

        double mid = (left + right)/2;

        if (mid*mid == x)
            return mid;

        if (Math.abs(mid*mid - x) < 0.1)
            return mid;

        if (mid*mid > x)
            sqrtUtil(left, mid, x);
        else
            sqrtUtil(mid+0.01, right, x);


        return -1;
    }
}
