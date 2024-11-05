import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] files = new String[N][2];
        Set<String> extensions = new HashSet<>();

        for(int i = 0; i < N; i++){
            String[] inputs = br.readLine().split("\\.");
            files[i][0] = inputs[0];
            files[i][1] = inputs[1];
        }

        for(int i = 0; i < M; i++){
            extensions.add(br.readLine());
        }
        br.close();
        Arrays.sort(files, (o1, o2) -> {
            if(!o1[0].equals(o2[0])){
                return o1[0].compareTo(o2[0]);
            }
            if(!o1[1].equals(o2[1])){
                if(extensions.contains(o1[1]) && !extensions.contains(o2[1])){
                    return -1;
                }else if(!extensions.contains(o1[1]) && extensions.contains(o2[1])){
                    return 1;
                }
            }
            return o1[1].compareTo(o2[1]);
        });

        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(files[i][0]).append(".").append(files[i][1]).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}