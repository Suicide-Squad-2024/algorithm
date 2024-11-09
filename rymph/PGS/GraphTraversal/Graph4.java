package PGS.GraphTraversal;

import java.util.*;

class Graph4 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[101][101];
        for (int i = 0; i < rectangle.length; i++) {
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int tx = rectangle[i][2] * 2;
            int ty = rectangle[i][3] * 2;
            for (int j = sx; j <= tx; j++) {
                for (int k = sy; k <= ty; k++) {
                    if ((j == sx || j == tx || k == sy || k == ty) && board[j][k] != 2) {
                        board[j][k] = 1;
                    } else {
                        board[j][k] = 2;
                    }
                }
            }
        }

        int answer = bfs(board, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }

    public int bfs(int[][] board, int sx, int sy, int tx, int ty) {
        boolean[][] visited = new boolean[101][101];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int ret = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();
            if (cur[0] == tx && cur[1] == ty) {
                ret = cur[2] / 2;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] != 1) {
                    continue;
                }

                queue.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return ret;
    }
}