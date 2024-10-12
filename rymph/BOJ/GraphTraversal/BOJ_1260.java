package BOJ.GraphTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ_1260 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        result = new int[N];
        sb = new StringBuilder();
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(start);
        sb.deleteCharAt(sb.length() - 1).append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        sb.deleteCharAt(sb.length() - 1).append("\n");

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[graph[start].get(i)]) {
                dfs(graph[start].get(i));
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(" ");
            for (int i = 0; i < graph[x].size(); i++) {
                if (!visited[graph[x].get(i)]) {
                    queue.add(graph[x].get(i));
                    visited[graph[x].get(i)] = true;
                }
            }
        }
    }
}
