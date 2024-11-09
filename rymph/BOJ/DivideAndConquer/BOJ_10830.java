package BOJ.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10830 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        br.close();

        int[][] result = subMatrix(B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.print(sb);
    }

    public static int[][] subMatrix(long exp) {
        if (exp == 1) {
            return board;
        } else {
            int[][] ret;
            int[][] temp = subMatrix(exp / 2);
            ret = multiplyMatrix(temp, temp);
            if (exp % 2 == 1) {
                ret = multiplyMatrix(ret, board);
            }
            return ret;
        }
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                }
                ret[i][j] = sum % 1000;
            }
        }

        return ret;
    }

}
