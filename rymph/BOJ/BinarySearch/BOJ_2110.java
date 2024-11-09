package BOJ.BinarySearch;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(maxLength(houses, C));

    }

    public static int maxLength(int[] houses, int c) {
        int answer = 0;
        int low = 1;
        int high = houses[houses.length - 1] - houses[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(houses, mid, c)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    public static boolean isValid(int[] houses, int key, int c) {
        int lastIndex = houses[0];
        int count = 1;
        for (int i = 1; i < houses.length; i++) {
            int distance = houses[i] - lastIndex;
            if (distance >= key) {
                count++;
                lastIndex = houses[i];
            }
        }
        return count >= c;
    }
}
