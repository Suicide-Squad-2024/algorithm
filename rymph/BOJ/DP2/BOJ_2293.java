package BOJ.DP2;

import java.io.*;
import java.util.*;

public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            for (int j = value; j <= K; j++) {
                dp[j] += dp[j - value];
            }
        }
        System.out.println(dp[K]);
    }
}