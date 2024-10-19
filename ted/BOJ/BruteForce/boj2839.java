package algoStudy.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i<=n ; i++){
            if(dp[i] == Integer.MAX_VALUE) continue;
            try{
                dp[i+3] = Math.min(dp[i] + 1,dp[i+3]);
                dp[i+5] = Math.min(dp[i] + 1,dp[i+5]);
            }catch (Exception e){
                continue;
            }

        }
        if(dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
