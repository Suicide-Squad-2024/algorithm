package BOJ.DP1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(minLines(lines));
    }

    public static int minLines(int[][] lines) {
        int N = lines.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return N - max;
    }
}
