package BOJ.DP2;

import java.io.*;
import java.util.*;

public class BOJ_11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] psum = new int[N + 1];
            int[][] dp = new int[N][];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                psum[j + 1] = psum[j] + value;
                int[] temp = new int[N - j];
                Arrays.fill(temp, Integer.MAX_VALUE);
                temp[0] = 0;
                dp[j] = temp;
            }
            bw.write(minCost(dp, psum) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int minCost(int[][] dp, int[] psum) {
        int N = dp.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                for (int k = 0; k < i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[j + k + 1][i - 1 - k] + psum[j + i + 1] - psum[j]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
