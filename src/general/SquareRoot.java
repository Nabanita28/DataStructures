package general;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSquareRoot(35));
    }

    private static double findSquareRoot(double num) {

        return sqrtUtil(0, num, num);
    }

    private static double sqrtUtil(double left, double right, double x) {

        double mid = (left + right)/2;
        double ans = -1;

        if (mid*mid == x)
            return mid;

        if (Math.abs(mid*mid - x) < 0.0001)
            return mid;

        if (mid*mid > x)
            ans = sqrtUtil(left, mid, x);
        else
            ans = sqrtUtil(mid, right, x);


        return ans;
    }
}
