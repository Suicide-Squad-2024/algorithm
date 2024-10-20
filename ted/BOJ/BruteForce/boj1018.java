package algoStudy.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018 {

    public static int checkPattern1(int[][] board, int x, int y){
        int count = 0;
        for(int i = x; i<x+8; i++){
            for(int j = y; j<y+8; j++){
                if((i+j)%2 ==0){
                    if(board[i][j]==0) count++;
                }
                else{
                    if(board[i][j]==1) count++;
                }
            }
        }
        return count;
    }
    public static int checkPattern2(int[][] board, int x, int y){
        int count = 0;
        for(int i = x; i<x+8; i++){
            for(int j = y; j<y+8; j++){
                if((i+j)%2 ==0){
                    if(board[i][j]==1) count++;
                }
                else{
                    if(board[i][j]==0) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int answer = 64;
        int[][] board = new int[x][y];
        for(int i = 0; i<x; i++){
            String row = br.readLine();
            for(int j = 0; j<y; j++){
                if(row.charAt(j)=='B') board[i][j] =1;
                else board[i][j] = 0;
            }
        }
        for(int i = 0; i<=x-8; i++){
            for(int j =0; j<=y-8;j++){
                answer = Math.min(checkPattern1(board,i,j), answer);
                answer = Math.min(checkPattern2(board,i,j), answer);
            }
        }
        System.out.println(answer);
        br.close();
    }
}
