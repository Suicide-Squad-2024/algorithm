package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        int threeMax = N / 3;
        int fiveMax = N / 5;
        int result = -1;

        Outer:
        for (int i = 0; i <= threeMax; i++) {
            Inner:
            for (int j = 0; j <= fiveMax; j++) {
                if (i * 3 + j * 5 == N) {
                    result = i + j;
                    break Outer;
                }
            }
        }
        System.out.println(result);
    }

}
