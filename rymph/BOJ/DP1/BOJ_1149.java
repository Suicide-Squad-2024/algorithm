package BOJ.DP1;

import java.util.*;
import java.io.*;

public class BOJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N][3];
        // costs[10][0] : 11번 집을 R로 칠하는 경우
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i - 1][0], costs[i - 1][1]) + costs[i][2];
        }
        return Math.min(costs[costs.length - 1][2], Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]));
    }
}
