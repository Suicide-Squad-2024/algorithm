package BOJ.DP1;

import java.io.*;

public class BOJ_1904 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        System.out.println(fib(N));

    }

    public static int fib(int n) {
        if (n <= 2) {
            return n;
        } else {
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
            return dp[n];
        }
    }
}
