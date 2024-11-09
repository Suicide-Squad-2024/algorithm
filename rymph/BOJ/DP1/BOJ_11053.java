package BOJ.DP1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
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
        int[] dp = new int[seq.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < seq.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}
