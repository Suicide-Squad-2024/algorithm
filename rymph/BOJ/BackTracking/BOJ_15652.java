package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        dfs(bw, stack, 1, N, M);
        bw.flush();
        bw.close();
    }

    public static void dfs(BufferedWriter bw, Stack<Integer> stack, int start, int end, int len) throws IOException {
        if (stack.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (Integer value : stack) {
                sb.append(value).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
            bw.write(sb.toString());
            return;
        }

        for (int i = start; i <= end; i++) {
            stack.push(i);
            dfs(bw, stack, i, end, len);
            stack.pop();
        }
    }
}
