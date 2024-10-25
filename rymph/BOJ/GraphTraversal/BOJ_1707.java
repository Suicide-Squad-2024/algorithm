package BOJ.GraphTraversal;

import java.io.*;
import java.util.*;

// 12:43
public class BOJ_1707 {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean answer1;
    static boolean answer2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            colors = new int[V + 1];
            answer1 = true;
            answer2 = true;
            for (int j = 0; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
/*
            for(int j = 1; j <= V; j++){
                if(!answer1)
                    break;

                if(colors[j] == 0){
                    dfs(j, 1);
                }
            }
*/
            for (int j = 1; j <= V; j++) {
                if (!answer2)
                    break;

                if (colors[j] == 0) {
                    bfs(j, 1);
                }
            }
            //System.out.println(answer1 ? "YES" : "NO");
            System.out.println(answer2 ? "YES" : "NO");
        }
    }

    public static void dfs(int start, int color) {
        colors[start] = color;

        for (int node : graph[start]) {
            if (colors[node] == color) {
                answer1 = false;
                return;
            }
            if (colors[node] == 0) {
                dfs(node, -color);
            }
        }
    }

    public static void bfs(int start, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        colors[start] = color;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == colors[node]) {
                    answer2 = false;
                    return;
                }
                if (colors[neighbor] == 0) {
                    queue.offer(neighbor);
                    colors[neighbor] = colors[node] * -1;
                }
            }
        }
    }
}
