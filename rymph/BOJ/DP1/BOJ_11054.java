package BOJ.DP1;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(maxLen(seq));
    }

    public static int maxLen(int[] seq) {
        int N = seq.length;
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }
                if (seq[N - 1 - i] > seq[N - 1 - j]) {
                    dp[N - 1 - i][1] = Math.max(dp[N - 1 - j][1] + 1, dp[N - 1 - i][1]);
                }
            }
        }

        int max = 1;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i][0] + dp[i][1] - 1);
        }

        return max;
    }
}
