package BOJ.MITM;

import java.io.*;
import java.util.*;

public class BOJ_1450 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> left = new ArrayList<>();
        ArrayList<Long> right = new ArrayList<>();

        dfs(left, 0, N / 2, C, 0);
        dfs(right, N / 2, N, C, 0);

        Collections.sort(left);
        Collections.sort(right);

        System.out.println(getCount(left, right, C));
        // System.out.println(getCount2(left, right, C));

    }

    public static void dfs(ArrayList<Long> subList, int start, int end, int target, long sum) {
        if (sum > target) return;
        if (start == end) {
            subList.add(sum);
            return;
        }
        dfs(subList, start + 1, end, target, sum + nums[start]);
        dfs(subList, start + 1, end, target, sum);
    }

    public static int getCount(ArrayList<Long> left, ArrayList<Long> right, int target) {
        int count = 0;
        int e = right.size() - 1;
        for (int i = 0; i < left.size(); i++) {
            while (e >= 0 && left.get(i) + right.get(e) > target) {
                e--;
            }
            count += e + 1;
        }
        return count;
    }

    public static int getCount2(ArrayList<Long> left, ArrayList<Long> right, int C) {
        int count = 0;
        int e = right.size() - 1;
        for (int i = 0; i < left.size(); i++) {
            long value = left.get(i);
            count += upperBound(right, C - value);
        }

        return count;
    }

    public static int upperBound(ArrayList<Long> list, long target) {
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
}
