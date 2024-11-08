import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] seq;
    static int[] dp;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        dp[N - 1] = 1;

        int answer = 1;
        for (int i = 0; i < seq.length; i++) {
            answer = Math.max(answer, dfs(-1, i));
        }
        System.out.println(answer);
        System.out.println(count);
    }
    // seq[index] < seq[i] -> dfs(i) + 1;

    public static int dfs(int prev, int index) {
        count++;
        System.out.println(prev + " " + index);
        if (dp[index] != 0) {
            return dp[index];
        }
        int ret = 1;
        for (int i = index + 1; i < seq.length; i++) {
            if (seq[index] < seq[i]) {
                ret = Math.max(dfs(index, i) + 1, ret);
            }
        }
        dp[index] = ret;
        return ret;
    }
}