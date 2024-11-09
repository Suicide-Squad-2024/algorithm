package BOJ.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(seq[0]);
        for (int i = 1; i < N; i++) {
            int last = dp.get(dp.size() - 1);
            if (seq[i] > last) {
                dp.add(seq[i]);
            } else if (seq[i] < last) {
                int index = lowerBound(dp, seq[i]);
                dp.set(index, seq[i]);
            }
        }

        System.out.println(dp.size());
    }

    public static int lowerBound(ArrayList<Integer> dp, int target) {
        int low = 0;
        int high = dp.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (dp.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
