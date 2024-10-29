package BOJ.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        System.out.println(getValue(N, K));

    }

    public static int getValue(int N, int K) {
        int answer = 0;
        int low = 1;
        int high = K;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(N, K, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static boolean isValid(int N, int K, int key) {
        int count = 0;
        for (int i = 1; i <= Math.min(key, N); i++) {
            count += Math.min(key / i, N);
        }

        return count >= K;
    }
}
