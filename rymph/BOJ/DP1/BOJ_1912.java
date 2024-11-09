package BOJ.DP1;

import java.io.*;
import java.util.*;

public class BOJ_1912 {
    static int[] dp;
    static int[] nums;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = nums[0];
        answer = dp[0];

        System.out.println(maxSeq(N));
    }

    public static int maxSeq(int n){
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
