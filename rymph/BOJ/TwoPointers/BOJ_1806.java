package BOJ.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1]; // 맨 뒤에 0 추가

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (end <= N) {
            if (sum < S) {
                sum += nums[end];
                end++;
            } else {
                minLength = Math.min(end - start, minLength);
                sum -= nums[start];
                start++;
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
