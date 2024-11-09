package BOJ.DP1;

import java.io.*;

public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        int M = A.length;
        int N = B.length;
        int[][] dp = new int[M + 1][N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[M][N]);
    }
}
