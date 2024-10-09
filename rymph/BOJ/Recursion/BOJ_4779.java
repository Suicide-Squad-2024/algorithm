package BOJ.Recursion;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ_4779 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            bw.write(cantor(N) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
    public static String cantor(int n){
        // 3**n 개의 -가 있을 때,
        if(n == 0){
            return "-";
        }else{
            return cantor(n - 1) + " ".repeat((int) Math.pow(3, n - 1)) + cantor(n - 1);
        }
    }
}
