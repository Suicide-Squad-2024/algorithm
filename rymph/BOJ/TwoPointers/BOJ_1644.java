package BOJ.TwoPointers;

import java.io.*;
import java.util.*;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isNotPrime = new boolean[N + 1];
        fillIsNotPrime(isNotPrime, N);

        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
        primes.add(0);

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while (end < primes.size()) {
            if (sum < N) {
                sum += primes.get(end);
                end++;
            } else if (sum > N) {
                sum -= primes.get(start);
                start++;
            } else {
                count++;
                sum -= primes.get(start);
                start++;
            }
        }

        System.out.println(count);
    }

    public static void fillIsNotPrime(boolean[] isNotPrime, int N) {
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}
