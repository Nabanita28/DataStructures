package dataStructuresPractice.math;

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        char[] directions = "GL".toCharArray();
        System.out.println("Is Robot Bounded in a circle - " + isRobotBounded(directions));
    }

   /* To resolve this problem, we must notice a couple of facts:
    1. If after the set of operations, the robot is still at the position (0, 0), then it is bounded
    2. If the robot doesn’t point North after the set of instructions, it will return to the point (0, 0) after 4 sets of instructions, pointing North, and repeat. Therefore, if the robot doesn’t point North after the set of operations, it is bounded.
    3. In all other cases, the robot is unbounded.*/
    private static boolean isRobotBounded(char[] directions) {
        int x = 0, y = 0;
        char dir = 'N';

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == 'G') {
                switch (dir) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
            } else if (directions[i] == 'L') {
                switch (dir) {
                    case 'N':
                        dir = 'W';
                        break;
                    case 'W':
                        dir = 'S';
                        break;
                    case 'S':
                        dir = 'E';
                        break;
                    case 'E':
                        dir = 'N';
                        break;
                }
            } else {
                switch (dir) {
                    case 'N':
                        dir = 'E';
                        break;
                    case 'W':
                        dir = 'N';
                        break;
                    case 'S':
                        dir = 'W';
                        break;
                    case 'E':
                        dir = 'S';
                        break;
                }
            }
        }

        return (x==0 && y==0) || (dir != 'N');
    }
}