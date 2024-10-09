package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

// 21:18 시작
public class BOJ_11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder sb = new StringBuilder();
        hanoi(sb, N, 1, 2, 3);
        bw.write((int) Math.pow(2, N) - 1 + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void hanoi(StringBuilder sb, int n, int src, int sub, int dest) {
        if (n == 1) {
            sb.append(src).append(" ").append(dest).append("\n");
        } else {
            // n개가 주어지면
            // n-1개를 1(src)에서 2(sub)로 옮김
            // n을 1에서 3으로 옮김
            // n-1개를 다시 2(sub)에서 3(dest)으로 옮김
            hanoi(sb, n - 1, src, dest, sub);
            sb.append(src).append(" ").append(dest).append("\n");
            hanoi(sb, n - 1, sub, src, dest);
        }
    }
}
