package BOJ.DP1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(scores[0]);
        } else {
            int[][] dp = new int[N][2];
            dp[0][0] = scores[0];
            dp[0][1] = 0;
            dp[1][0] = scores[0] + scores[1];
            dp[1][1] = scores[1];
            for (int i = 2; i < N; i++) {
                dp[i][0] = dp[i - 1][1] + scores[i];
                dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + scores[i];
            }

            System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
        }
    }
}
