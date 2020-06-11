package maxSubArray;

public class maxSubArray {
    public static int maxSubArray (int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int n:nums){
            sum = sum>0?sum+n:n;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-5, -6, 2};
        System.out.println(maxSubArray(nums));
    }
}
