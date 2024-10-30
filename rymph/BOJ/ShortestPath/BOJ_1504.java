package BOJ.ShortestPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class BOJ_1504 {
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        br.close();
        System.out.println(dijkstra(v1, v2, 1, N));

    }

    public static int dijkstra(int v1, int v2, int start, int end) {

        boolean[][] visited = new boolean[2][graph.length];
        int[][] dist = new int[2][graph.length];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][v1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{v1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[0][cur[0]]) {
                continue;
            }
            visited[0][cur[0]] = true;
            for (int[] node : graph[cur[0]]) {
                if (dist[0][node[0]] > dist[0][cur[0]] + node[1]) {
                    dist[0][node[0]] = dist[0][cur[0]] + node[1];
                    pq.add(new int[]{node[0], dist[0][node[0]]});
                }
            }
        }

        dist[1][v2] = 0;
        pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{v2, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[1][cur[0]]) {
                continue;
            }
            visited[1][cur[0]] = true;
            for (int[] node : graph[cur[0]]) {
                if (dist[1][node[0]] > dist[1][cur[0]] + node[1]) {
                    dist[1][node[0]] = dist[1][cur[0]] + node[1];
                    pq.add(new int[]{node[0], dist[1][node[0]]});
                }
            }
        }

        int v1ToV2 = dist[0][v2];

        if (v1ToV2 == Integer.MAX_VALUE) {
            return -1;
        } else {
            int min = Integer.MAX_VALUE;
            int v1ToStart = dist[0][start];
            int v2ToEnd = dist[1][end];
            int v1ToEnd = dist[0][end];
            int v2ToStart = dist[1][start];
            if (v1ToStart != Integer.MAX_VALUE && v2ToEnd != Integer.MAX_VALUE) {
                min = Math.min(min, v1ToV2 + v1ToStart + v2ToEnd);
            }
            if (v2ToStart != Integer.MAX_VALUE && v1ToEnd != Integer.MAX_VALUE) {
                min = Math.min(min, v1ToV2 + v2ToStart + v1ToEnd);
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
}
