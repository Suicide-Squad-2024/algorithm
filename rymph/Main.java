import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int farthest = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            for (int j = 1; j < inputs.length - 1; j += 2) {
                int b = Integer.parseInt(inputs[j]);
                int c = Integer.parseInt(inputs[j + 1]);
                graph[a].add(new int[]{b, c});
                graph[b].add(new int[]{a, c});
            }
        }

        br.close();

        visited = new boolean[V + 1];
        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(farthest, 0);

        System.out.println(max);
    }

    public static void dfs(int start, int sum) {
        if (sum > max) {
            max = sum;
            farthest = start;
        }
        visited[start] = true;
        for (int[] node : graph[start]) {
            if (!visited[node[0]]) {
                dfs(node[0], sum + node[1]);
            }
        }
    }
}