package PGS.Hash;

import java.util.*;

public class Hash2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counts = new HashMap<>();
        for (String person : participant) {
            counts.put(person, counts.getOrDefault(person, 0) + 1);
        }

        for (String person : completion) {
            if (counts.containsKey(person)) {
                counts.put(person, counts.get(person) - 1);
                if (counts.get(person) == 0) {
                    counts.remove(person);
                }
            }
        }

        String answer = "";
        for (String person : counts.keySet()) {
            answer += person;
        }

        return answer;
    }
}