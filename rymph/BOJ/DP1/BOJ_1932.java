package BOJ.DP1;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N * (N + 1) / 2];
        for (int i = 0; i < N; i++) {
            int row = i * (i + 1) / 2;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                nums[row + j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            int curRow = i * (i + 1) / 2;
            int nextRow = (i + 1) * (i + 2) / 2;

            for (int j = 0; j <= i; j++) {
                nums[curRow + j] = Math.max(nums[nextRow + j], nums[nextRow + j + 1]) + nums[curRow + j];
            }
        }

        System.out.println(nums[0]);
    }
}
