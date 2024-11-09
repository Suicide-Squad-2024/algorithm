package BOJ.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
        increaseCount(board, 0, 0, N);
        bw.write(zeroCount + "\n");
        bw.write(oneCount + "\n");
        bw.flush();
        bw.close();

    }

    public static void increaseCount(int[][] board, int row, int col, int size) {
        if (isOne(board, row, col, size)) {
            oneCount++;
        } else if (isZero(board, row, col, size)) {
            zeroCount++;
        } else {
            int half = size / 2;
            increaseCount(board, row, col, half);
            increaseCount(board, row + half, col, half);
            increaseCount(board, row, col + half, half);
            increaseCount(board, row + half, col + half, half);
        }

    }

    public static boolean isOne(int[][] board, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[row + i][col + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isZero(int[][] board, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[row + i][col + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
