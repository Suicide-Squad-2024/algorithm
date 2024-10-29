package BOJ.GraphTraversal;

import java.io.*;
import java.util.*;

public class BOJ_16928 {
    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        Map<Integer, Integer> teleport = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            teleport.put(from, to);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            teleport.put(from, to);
        }
        br.close();
        bfs(teleport, 1);

        System.out.println(answer);
    }

    public static void bfs(Map<Integer, Integer> teleport, int start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int time = cur[1];
            if (cx == 100) {
                answer = time;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = cx + i;
                if (nx < 1 || nx > 100) {
                    continue;
                }
                if (teleport.containsKey(nx)) {
                    nx = teleport.get(nx);
                }
                if (visited[nx]) {
                    continue;
                }
                queue.offer(new int[]{nx, time + 1});
                visited[nx] = true;
            }
        }
    }
}
