package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];
        dfs(stack, visited, 1, N, M);
    }

    public static void dfs(Stack<Integer> stack, boolean[] visited, int start, int end, int len) {
        if (stack.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (Integer value : stack) {
                sb.append(value).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }

        for (int i = start; i <= end; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(i);
                dfs(stack, visited, start, end, len);
                stack.pop();
                visited[i] = false;
            }
        }
    }
}
