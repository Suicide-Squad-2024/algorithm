package algoStudy.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {
    static int N;
    static int[] board;

    static int answer;

    static void dfs(int depth){
        if(depth == N){
            answer++;
            return;
        }
        if(depth == 0){
            for(int i = 0 ; i<N; i++){
                board[0] = i;
                dfs(depth+1);
            }
            return;
        }
        for(int i = 0; i< N; i++){
            boolean isValid = true;
            for(int j = 0; j <depth; j++){
                if(Math.abs(board[j]-i)==Math.abs(j-depth) || board[j] == i){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                board[depth] = i;
                dfs(depth+1);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        board = new int[N];
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }
}
