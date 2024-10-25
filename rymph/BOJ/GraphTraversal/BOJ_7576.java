package BOJ.GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static ArrayList<int[]> points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        points = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    points.add(new int[]{i, j});
                }
                board[i][j] = value;
            }
        }
        br.close();
        System.out.println(bfs());
    }
    public static int bfs(){
        Queue<int[]> queue = new LinkedList<>(points);
        int ret = 0;
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            ret = board[point[0]][point[1]];
            for(int i = 0; i < 4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(isValid(nx, ny)){
                    board[nx][ny] = board[point[0]][point[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        if(isFull()){
            return ret - 1;
        }else{
            return -1;
        }
    }
    public static boolean isValid(int x, int y){
        return !(x < 0 || x >= board.length || y < 0 || y >= board[0].length) && board[x][y] == 0;
    }

    public static boolean isFull(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
