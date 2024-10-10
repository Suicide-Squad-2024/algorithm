package BOJ.GraphTraversal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    static int cnt;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        br.close();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (Integer value : list) {
            bw.write(value + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int row, int col) {

        board[row][col] = 0;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int mx = row + dx[i];
            int my = col + dy[i];
            if (mx < 0 || mx >= N || my < 0 || my >= N) {
                continue;
            }
            if (board[mx][my] == 0) {
                continue;
            }
            dfs(mx, my);
        }
    }
}
