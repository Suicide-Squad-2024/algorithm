package BOJ.MITM;

import java.io.*;
import java.util.*;

public class BOJ_1208 {
    static int[] nums;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        count = 0;

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        dfs(left, 0, N / 2, 0);
        dfs(right, N / 2, N, 0);

        Collections.sort(left);
        Collections.sort(right);

        incCount(left, right, S);
        // incCount2(left, right, S);

        System.out.println(S == 0 ? count - 1 : count);

    }

    public static void dfs(ArrayList<Integer> sublist, int start, int end, int sum) {
        if (start == end) {
            sublist.add(sum);
            return;
        }

        dfs(sublist, start + 1, end, sum + nums[start]);
        dfs(sublist, start + 1, end, sum);
    }

    public static void incCount(ArrayList<Integer> left, ArrayList<Integer> right, int S) {
        int s = 0;
        int e = right.size() - 1;

        while (s < left.size() && e >= 0) {
            int sum = left.get(s) + right.get(e);
            if (sum < S) {
                s++;
            } else if (sum > S) {
                e--;
            } else {
                long count1 = 0;
                int value = left.get(s);
                while (s < left.size() && left.get(s) == value) {
                    s++;
                    count1++;
                }

                long count2 = 0;
                value = right.get(e);
                while (e >= 0 && right.get(e) == value) {
                    e--;
                    count2++;

                }
                count += count1 * count2;
            }
        }
    }

    public static int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int upperBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static void incCount2(ArrayList<Integer> left, ArrayList<Integer> right, int S) {

        for (int value : left) {
            count += upperBound(right, S - value) - lowerBound(right, S - value);
        }
    }
}
