package BOJ.PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 03:45
public class BOJ_25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        br.close();

        int min = Math.min(minStart(board, 'W', K), minStart(board, 'B', K));
        System.out.println(min);

    }

    public static int minStart(char[][] board, char start, int k) {
        int n = board.length;
        int m = board[0].length;
        int[][] psum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int plus = 0;
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != start) {
                        plus = 1;
                    }
                } else {
                    if (board[i][j] == start) {
                        plus = 1;
                    }
                }
                psum[i + 1][j + 1] = psum[i][j + 1] + psum[i + 1][j] - psum[i][j] + plus;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                int value = psum[i + k][j + k] - psum[i][j + k] - psum[i + k][j] + psum[i][j];
                min = Math.min(min, value);
            }
        }

        return min;
    }

}
