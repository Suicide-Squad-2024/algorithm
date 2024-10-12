package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int result = countInMatrix(board);

        System.out.println(result);

    }

    public static int countInMatrix(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int count1 = Integer.MAX_VALUE;
        int count2 = Integer.MAX_VALUE;

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                count1 = Math.min(countInSubMatrix(board, 'W', i, j), count1);
                count2 = Math.min(countInSubMatrix(board, 'B', i, j), count2);
            }
        }

        return Math.min(count1, count2);
    }

    public static int countInSubMatrix(char[][] board, char start, int startRow, int startCol) {
        int count = 0;

        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if ((i + j) % 2 == 0 && board[i][j] != start) {
                    count++;
                } else if ((i + j) % 2 == 1 && board[i][j] == start) {
                    count++;
                }
            }
        }

        return count;
    }
}
