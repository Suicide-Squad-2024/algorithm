package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        br.close();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, stack, 1, N, M);
        System.out.println(sb);
    }

    public static void dfs(StringBuilder sb, Stack<Integer> stack, int start, int end, int len) {
        if (stack.size() == len) {
            for (Integer value : stack) {
                sb.append(value).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            return;
        }

        for (int i = start; i <= end; i++) {
            stack.push(i);
            dfs(sb, stack, start, end, len);
            stack.pop();
        }
    }
}
