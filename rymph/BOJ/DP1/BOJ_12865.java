package BOJ.DP1;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        int[][] items = new int[N][2]; // 0 : weight, 1 : value
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int W = items[i][0];
            int V = items[i][1];
            for (int j = K; j > W - 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);


    }
}
