package PGS.Hash;

import java.util.*;

public class Hash3 {
    public boolean solution(String[] phone_book) {

        Set<String> numbers = new HashSet<>(Arrays.asList(phone_book));

        for (String cur : phone_book) {
            for (int j = 1; j < cur.length(); j++) {
                if (numbers.contains(cur.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
