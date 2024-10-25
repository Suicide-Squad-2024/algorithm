import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(nums, 11, 9));
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