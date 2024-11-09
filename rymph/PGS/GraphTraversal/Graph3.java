package PGS.GraphTraversal;

import java.util.*;

class Graph3 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {

        int N = maps.length;
        int M = maps[0].length;

        int answer = bfs(maps, 0, 0, N - 1, M - 1);
        return answer;
    }

    public int bfs(int[][] maps, int sx, int sy, int tx, int ty) {
        int ret = -1;
        boolean[][] visited = new boolean[tx + 1][ty + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 1});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tx && cur[1] == ty) {
                ret = cur[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > tx || ny < 0 || ny > ty) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (maps[nx][ny] == 0) {
                    continue;
                }
                queue.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return ret;
    }
}