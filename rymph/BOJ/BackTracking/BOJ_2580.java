package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_2580 {

    public static class Coords {
        private int row;
        private int col;

        public Coords(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }
    }

    static int[][] board;
    static ArrayList<Coords> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) {
                    list.add(new Coords(i, j));
                }
                board[i][j] = input;
            }
        }
        dfs(list, 0);
    }

    public static void dfs(ArrayList<Coords> list, int k) {
        if (list.size() == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1).append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        Coords coords = list.get(k);
        int cx = coords.getRow();
        int cy = coords.getCol();
        for (int i = 1; i <= 9; i++) {
            if (isPromising(cx, cy, i)) {
                board[cx][cy] = i;
                dfs(list, k + 1);
                board[cx][cy] = 0;
            }
        }
    }

    public static boolean isPromising(int row, int col, int val) {
        int sx = (row / 3) * 3;
        int sy = (col / 3) * 3;
        return isRowValid(row, val) && isColValid(col, val) && isSquareValid(sx, sy, val);
    }

    public static boolean isRowValid(int row, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean isColValid(int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquareValid(int sx, int sy, int val) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sx + i][sy + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
