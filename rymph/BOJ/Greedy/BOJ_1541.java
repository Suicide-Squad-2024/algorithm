package BOJ.Greedy;

import java.io.*;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("-");
        int sum = partialSum(inputs[0]);

        for (int i = 1; i < inputs.length; i++) {
            sum -= partialSum(inputs[i]);
        }

        System.out.println(sum);
    }

    public static int partialSum(String input) {
        String[] subInputs = input.split("\\+");
        int sum = 0;
        for (String sub : subInputs) {
            sum += Integer.parseInt(sub);
        }
        return sum;
    }
}
