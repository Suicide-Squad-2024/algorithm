package BOJ.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;
//02:30

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];
        for (int i = 0; i < K; i++) {
            int value = Integer.parseInt(br.readLine());
            lines[i] = value;
            max = Math.max(max, value);
        }

        System.out.println(maxLength(lines, max, N));
    }

    public static int maxLength(int[] lines, int max, int n) {
        int answer = 0;
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(lines, mid, n)) {
                answer = mid;
                if (answer == Integer.MAX_VALUE) {
                    break;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static boolean isValid(int[] lines, int key, int n) {
        int count = 0;
        for (int line : lines) {
            count += line / key;
        }
        return count >= n;
    }
}