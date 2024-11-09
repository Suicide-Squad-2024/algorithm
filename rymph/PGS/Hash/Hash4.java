package PGS.Hash;

import java.util.*;

public class Hash4 {
    public int solution(String[][] clothes) {
        Map<String, Integer> categories = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            categories.put(clothes[i][1], categories.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;

        for (String category : categories.keySet()) {
            answer *= (categories.get(category) + 1);
        }
        answer--;

        return answer;
    }
}