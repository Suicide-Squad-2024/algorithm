package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14889 {
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] capacity = new int[N][N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                capacity[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        dfs(capacity, visited, 0, N, 0);
        System.out.println(minValue);
    }

    public static void dfs(int[][] capacity, boolean[] visited, int si, int n, int size) {
        if (size == n / 2) {
            int startScore = 0;
            int linkScore = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        startScore += capacity[i][j] + capacity[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        linkScore += capacity[i][j] + capacity[j][i];
                    }
                }
            }
            minValue = Math.min(minValue, Math.abs(startScore - linkScore));
            return;
        }

        for (int i = si; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(capacity, visited, i + 1, n, size + 1);
                visited[i] = false;
            }
        }
    }
}
