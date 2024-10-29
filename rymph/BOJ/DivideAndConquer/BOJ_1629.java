package BOJ.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(answer(A, B, C));

    }

    public static long answer(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        } else {
            long temp = answer(A, B / 2, C);
            long l = ((temp % C) * (temp % C)) % C;
            if (B % 2 == 0) {
                return l;
            } else {
                return (l * (A % C)) % C;
            }
        }
    }
}
