package PGS.GraphTraversal;

import java.util.*;

class Graph2 {
    public int solution(int n, int[][] computers) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(graph, visited, i);
            }
        }

        return answer;
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        visited[start] = true;
        for (int node : graph[start]) {
            if (!visited[node]) {
                dfs(graph, visited, node);
            }
        }
    }
}