package graph.mustDo;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderProblem {
    public static void main(String[] args) {
        int numberOfVertices = 30;
        int[] board = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            board[i] = -1;
        }

        board[2] = 21;
        board[4] = 7;
        board[10] = 25;
        board[19] = 28;

        board[27] = 0;
        board[20] = 8;
        board[16] = 3;
        board[18] = 6;
        System.out.println("Minimum number of moves required : " + findMinimumNumberOfMoves(board));
    }

    static class BoardEntry {
        int vertex;
        int distance;
    }

    private static int findMinimumNumberOfMoves(int[] board) {
        int boardSize = board.length;
        Queue<BoardEntry> queue = new LinkedList<>();
        boolean[] visited = new boolean[boardSize];
        BoardEntry entry = new BoardEntry();
        entry.vertex = 0;
        entry.distance = 0;
        visited[0] = true;
        queue.add(entry);

        while (!queue.isEmpty()) {
            entry = queue.remove();
            int curVertex = entry.vertex;

            if (curVertex == boardSize-1) break;

            //calculate distance of each vertex
            for (int j = curVertex + 1; j <= (curVertex + 6) && j < boardSize; j++) {
                if (!visited[j]) {

                    BoardEntry newEntry = new BoardEntry();
                    newEntry.distance = entry.distance + 1;
                    visited[j] = true;

                    if (board[j] != -1) {
                        newEntry.vertex = board[j];
                    } else {
                        newEntry.vertex = j;
                    }
                    queue.add(newEntry);
                }
            }

        }
        return entry.distance;
    }
}