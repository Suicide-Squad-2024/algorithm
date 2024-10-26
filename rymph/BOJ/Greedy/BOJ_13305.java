package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] lens = new BigInteger[N - 1];
        BigInteger[] costs = new BigInteger[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            lens[i] = new BigInteger(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            costs[i] = new BigInteger(st.nextToken());
        }

        BigInteger total = costs[0].multiply(lens[0]);
        BigInteger minPrice = costs[0];

        for (int i = 1; i < N - 1; i++) {
            if (costs[i].compareTo(minPrice) < 0) {
                minPrice = costs[i];
            }
            total = total.add(minPrice.multiply(lens[i]));
        }

        System.out.println(total);
    }
}
