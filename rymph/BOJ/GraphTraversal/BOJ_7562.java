package BOJ.GraphTraversal;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_7562 {
    static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            bw.write(bfs(startX, startY, targetX, targetY) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        board[startX][startY] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == targetX && cur[1] == targetY) {
                break;
            }
            for(int i = 0; i < dx.length; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if(isValid(board, nextX, nextY)) {
                    queue.offer(new int[]{nextX, nextY});
                    board[nextX][nextY] = board[cur[0]][cur[1]] + 1;
                }
            }
        }
        return board[targetX][targetY] - 1;
    }
    public static boolean isValid(int[][] board, int x, int y){
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length) && board[x][y] == 0;
    }
}
