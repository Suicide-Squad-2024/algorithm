package BOJ.DP2;

import java.io.*;
import java.util.*;

public class BOJ_1520 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    static int[][] board, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        dp = new int[M][N];

        for(int i = 0; i < M; i++){
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dp[M-1][N-1] = 1;

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int row, int col){
        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int result = 0;
        for(int i = 0; i < 4; i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if(nrow < 0 || nrow >= M || ncol < 0 || ncol >= N){
                continue;
            }

            if(board[nrow][ncol] < board[row][col]){
                result += dfs(nrow, ncol);
            }
        }
        dp[row][col] = result;
        return result;
    }
}
