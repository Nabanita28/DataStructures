package graph;

public class RainWaterBricks {

    static int[][] wall = new int[][]{
            //0 is porous, 1 is hollow
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1}
    };

    public static void main(String[] args) {
        System.out.println(isPossible());
    }

    private static boolean isPossible() {
        for (int col = 0; col < wall[0].length; col++) {
            if (wall[wall.length - 1][col] == 0) {
                boolean result = recursive(wall.length - 1, col);
                if (result) return true;
            }
        }
        return false;
    }

    private static boolean recursive(int row, int col) {

        if (row == 0) {
            return true;
        }

        int[][] porousNeighbours = getPorousNeighbours(row, col);
        if (porousNeighbours != null) {
            for (int i = 0; i < porousNeighbours.length; i++) {
                int[] brick = porousNeighbours[i];
                if (wall[brick[0]][brick[1]] == 0) {
                    boolean result = recursive(brick[0], brick[1]);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    private static int[][] getPorousNeighbours(int row, int col) {
        int[][] neighbours;
        if (row == 0) {
            return null;
        }
        if (col == 0) {
            neighbours = new int[][]{
                    {row - 1, col},
                    {row - 1, col + 1}
            };
            return neighbours;
        }

        if (col == wall[0].length - 1) {
            neighbours = new int[][]{
                    {row - 1, col - 1},
                    {row - 1, col}};
            return neighbours;
        }

        neighbours = new int[][]{
                {row - 1, col - 1},
                {row - 1, col},
                {row - 1, col + 1},
        };
        return neighbours;
    }
}
