package algoStudy.BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class boj15650 {
    static int N;
    static int M;

    static StringBuilder sb;

    static void comb(int depth, int index, String str, int[] numArray){
        if(depth == M){
            sb.append(str).append("\n");
            return;
        }
        for(int i = index ; i < N; i++){
            comb(depth+1, i+1, str + numArray[i] + " ", numArray);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] numArray = new int[N];
        sb = new StringBuilder();
        for(int i =0 ; i<N ; i++){
            numArray[i] = i+1;
        }
        comb(0,0, "", numArray);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
