import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        br.close();
        System.out.println(bfs(visited, N, K));
    }

    public static int bfs(boolean[] visited, int start, int target) {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int p = cur[0];
            time = cur[1];
            if(p == target){
                break;
            }
            else{
                int np1 = p * 2;
                int np2 = p + 1;
                int np3 = p - 1;
                if(isRange(np1) && !visited[np1]) {
                    queue.offer(new int[] {np1, time + 1});
                    visited[np1] = true;
                }
                if(isRange(np2) && !visited[np2]) {
                    queue.offer(new int[] {np2, time + 1});
                    visited[np2] = true;
                }
                if(isRange(np3) && !visited[np3]) {
                    queue.offer(new int[] {np3, time + 1});
                    visited[np3] = true;
                }
            }
        }
        return time;
    }

    public static boolean isRange(int x) {
        return (x >= 0 && x <= 100000);
    }
}