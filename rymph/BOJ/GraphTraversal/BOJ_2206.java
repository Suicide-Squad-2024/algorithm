package BOJ.GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int N;
    static int M;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        boolean[][][] visited = new boolean[2][N][M];
        Queue<int[]> queue = new LinkedList<>();

        // x, y, 벽뚫, cnt
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            if (point[0] == N - 1 && point[1] == M - 1) {
                return point[3];
            }

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (point[2] == 1) { // 벽뚫 있음
                        // 벽이 아니고, 방문한 적 없음
                        if (board[nx][ny] == 0 && !visited[1][nx][ny]) {
                            visited[1][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, 1, point[3] + 1});
                        }
                    } else { // 벽뚫 없음
                        // 벽이고, 방문한 적 없음
                        if (board[nx][ny] == 1 && !visited[1][nx][ny]) {
                            visited[1][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, 1, point[3] + 1});
                        // 벽이 아니고, 방문한 적 없음
                        } else if (board[nx][ny] == 0 && !visited[0][nx][ny]) {
                            visited[0][nx][ny] = true;
                            queue.offer(new int[]{nx, ny, 0, point[3] + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }
}