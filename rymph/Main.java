import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        SortedMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        System.out.println(map.tailMap(2));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        System.out.println(map.toString());
    }
    public static int binarySearch(int[] nums, int target, int n) {
        int low = 0; int high = n-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                high = mid-1;
            }
            else if(target>nums[mid]){
                low = mid + 1;
            }
        }
        return low;
    }
}