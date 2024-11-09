package PGS.Sort;

import java.util.*;

class Sort2 {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numStrs.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStrs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (numStrs[0].equals("0")) {
            return "0";
        }
        for (String numStr : numStrs) {
            sb.append(numStr);
        }

        return sb.toString();
    }
}