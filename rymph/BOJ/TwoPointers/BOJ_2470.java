package BOJ.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int start = 0;
        int end = N - 1;
        int answer1 = -1; // -1은 불가능한 값
        int answer2 = -1; // -1은 불가능한 값
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int value = nums[start] + nums[end];
            if (Math.abs(value) < min) {
                min = Math.abs(value);
                answer1 = start;
                answer2 = end;
            }

            if (value == 0) {
                break;
            } else if (value > 0) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(nums[answer1] + " " + nums[answer2]);
    }
}
