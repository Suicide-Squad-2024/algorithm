package BOJ.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());
        br.close();

        Arrays.sort(nums);

        // parametric search
        /*
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(2 * nums[i] >= X){
                break;
            }
            if(getIndex(nums, i + 1, X - nums[i]) != -1){
                answer++;
            }
        }
        System.out.println(answer);
         */

        // two pointers
        System.out.println(getCount(nums, X));


    }

    public static int getIndex(int[] nums, int start, int target) {
        int low = start;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int getCount(int[] nums, int target) {
        int count = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                count++;
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}
