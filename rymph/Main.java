import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp = new int[14][14];
        int init = 1;
        for(int i = 0; i < 14; i++){
            dp[0][i] = init;
            init += (i+2);
        }
        for(int i = 0; i < 14; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < 14; i++){
            for(int j = 1; j < 14; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        for(int i = 0; i < T; i++){
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[K-1][N-1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}