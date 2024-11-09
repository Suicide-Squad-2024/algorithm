package BOJ.DivideAndConquer;

import java.io.*;

public class BOJ_1992 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        makeString(board, 0, 0, N);

        System.out.println(sb);


    }

    public static void makeString(char[][] board, int row, int col, int size) {
        if (isOne(board, row, col, size)) {
            sb.append("1");
        } else if (isZero(board, row, col, size)) {
            sb.append("0");
        } else {
            int half = size / 2;
            sb.append("(");
            makeString(board, row, col, half);
            makeString(board, row, col + half, half);
            makeString(board, row + half, col, half);
            makeString(board, row + half, col + half, half);
            sb.append(")");
        }
    }

    public static boolean isOne(char[][] board, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[row + i][col + j] == '0') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isZero(char[][] board, int row, int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[row + i][col + j] == '1') {
                    return false;
                }
            }
        }
        return true;
    }
}
