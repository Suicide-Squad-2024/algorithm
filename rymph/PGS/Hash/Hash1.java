package PGS.Hash;

import java.util.*;

public class Hash1 {
    public int solution(int[] nums) {
        Set<Integer> kinds = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            kinds.add(nums[i]);
        }
        return Math.min(kinds.size(), length / 2);
    }
}