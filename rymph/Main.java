public class Main {
    public static void main(String[] args)  {
        int[] nums = {1, 2, 3, 5, 7, 10};

        int count = 0;
        int target = 5;

        int s = 0;
        int e = 5;

        while(s < e){
            int sum = nums[s] + nums[e];
            if(sum < target){
                s++;
            }else if(sum > target){
                count += (e - s);
                e--;
            }else{
                count += (e - s);
                s++;
                e--;
            }
        }

        System.out.println(count);
    }
}