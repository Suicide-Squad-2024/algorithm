package BOJ.MITM;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static int[] nums;
    static int N, S;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        count = 0;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(S == 0 ? count - 1 : count);
    }

    public static void dfs(int start, int sum) {
        if (start == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(start + 1, sum + nums[start]);
        dfs(start + 1, sum);
    }
}
