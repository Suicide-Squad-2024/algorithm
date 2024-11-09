package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int total = 0;
        int cur = 0;

        for (int i = 0; i < N; i++) {
            cur += time[i];
            total += cur;
        }

        System.out.println(total);
    }
}
