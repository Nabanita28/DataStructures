package dataStructuresPractice.general;

public class CubeRoot {
    public static void main(String[] args) {
        System.out.println(findCubeRoot(8));
    }

    private static double findCubeRoot(double num) {

        return cubeRootUtil(0, num, num);
    }

    private static double cubeRootUtil(double left, double right, double x) {

        double mid = (left + right)/2;
        double ans = -1;

        if (mid*mid*mid == x)
            return mid;

        if (Math.abs(mid*mid*mid - x) < 0.0001)
            return mid;

        if (mid*mid > x)
            ans = cubeRootUtil(left, mid, x);
        else
            ans = cubeRootUtil(mid, right, x);


        return ans;
    }
}
