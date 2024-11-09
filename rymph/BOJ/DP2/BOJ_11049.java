package BOJ.DP2;

import java.io.*;
import java.util.*;

public class BOJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        int[][] dp = new int[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
            dp[i] = new int[N - i];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        br.close();
        System.out.println(minCount(dp, matrix));
    }

    public static int minCount(int[][] dp, int[][] matrix) {
        int N = matrix.length;
        for (int gap = 1; gap < N; gap++) {
            for (int start = 0; start < N - gap; start++) {
                for (int count = 0; count < gap; count++) {
                    dp[start][gap] = Math.min(dp[start][gap],
                            dp[start][count] + dp[start + count + 1][gap - 1 - count] + matrix[start][0] * matrix[start + count][1] * matrix[start + gap][1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
