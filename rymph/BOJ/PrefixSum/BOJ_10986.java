package BOJ.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long psum = 0;
        long[] remCnt = new long[M];

        st = new StringTokenizer(br.readLine());
        br.close();
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            psum = (psum + value) % M;
            remCnt[(int) psum]++;
        }

        long answer = remCnt[0];

        for(int i = 0; i < M; i++){
            long cnt = remCnt[i];
            answer += ((cnt * (cnt - 1)) / 2);
        }

        System.out.println(answer);
    }

}
