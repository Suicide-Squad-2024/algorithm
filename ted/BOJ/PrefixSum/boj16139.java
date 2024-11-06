package algoStudy.PrefixSum;

import java.io.*;
import java.util.StringTokenizer;

public class boj16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[][] alphabet = new int[str.length()+1][26];
        for(int i = 1; i <= str.length(); i++){
            for(int j = 0; j<26;j++){
                if(j == str.charAt(i-1)-'a'){
                    alphabet[i][j] = alphabet[i-1][j] +1;
                }
                else {
                    alphabet[i][j] = alphabet[i-1][j];
                }
            }

        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int firstIndex = Integer.parseInt(st.nextToken());
            int lastIndex = Integer.parseInt(st.nextToken());
            bw.write(alphabet[lastIndex+1][c-'a'] - alphabet[firstIndex][c-'a']+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
