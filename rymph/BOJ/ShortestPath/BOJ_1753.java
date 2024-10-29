package BOJ.ShortestPath;

import java.io.*;
import java.util.*;

public class BOJ_1753 {
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        br.close();

        dijkstra(start);
    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (visited[node[0]]) {
                continue;
            }
            visited[node[0]] = true;
            for (int[] neighbour : graph[node[0]]) {
                if (dist[neighbour[0]] > dist[node[0]] + neighbour[1]) {
                    dist[neighbour[0]] = dist[node[0]] + neighbour[1];
                    pq.offer(new int[]{neighbour[0], dist[neighbour[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            int distance = dist[i];
            if (distance == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance).append("\n");
            }
        }

        System.out.print(sb);
    }
}
