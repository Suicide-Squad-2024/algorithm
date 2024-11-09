package BOJ.DP1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] volumes = new int[N];
        for (int i = 0; i < N; i++) {
            volumes[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        if (N == 1) {
            System.out.println(volumes[0]);
        } else if (N == 2) {
            System.out.println(volumes[0] + volumes[1]);
        } else {
            dp[0] = volumes[0];
            dp[1] = volumes[0] + volumes[1];
            dp[2] = Math.max(Math.max(dp[1], dp[0] + volumes[2]), volumes[1] + volumes[2]);
            for (int i = 3; i < N; i++) {
                int cand1 = dp[i - 3] + volumes[i - 1] + volumes[i];
                int cand2 = dp[i - 1];
                int cand3 = dp[i - 2] + volumes[i];
                dp[i] = Math.max(cand1, Math.max(cand2, cand3));
            }
            System.out.println(dp[N - 1]);
        }
    }
}
