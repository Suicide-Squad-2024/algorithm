package BOJ.DP1;

import java.io.*;

public class BOJ_9461 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(pSequence(N) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }

    public static long pSequence(int n) {
        if (dp[n] == 0) {
            dp[n] = pSequence(n - 2) + pSequence(n - 3);
        }

        return dp[n];
    }
}
