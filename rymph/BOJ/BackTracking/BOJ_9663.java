package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int[] board = new int[N];
        boolean[] used = new boolean[N];
        dfs(board, used, 0, N);
        System.out.println(answer);
    }

    public static boolean isPromising(int[] board, boolean[] used, int row, int candidate) {
        if (used[candidate]) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            if (board[i] == candidate || Math.abs(board[i] - candidate) == (row - i)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int[] board, boolean[] used, int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isPromising(board, used, row, i)) {
                board[row] = i;
                used[i] = true;
                dfs(board, used, row + 1, n);
                used[i] = false;
            }
        }
    }
}
