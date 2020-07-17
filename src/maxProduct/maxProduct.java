package maxProduct;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/18
 */
public class maxProduct {

    public static int maxProduct(int[] nums) {
        int len = nums.length, max = nums[0], dpMax=nums[0], dpMin=nums[0];

        for (int i = 1; i < len; i++) {
            if(nums[i]<0){
                int tmp = dpMax;
                dpMax = dpMin;
                dpMin =tmp;
            }
            dpMax = Math.max(nums[i], dpMax*nums[i]);
            dpMin = Math.min(nums[i], dpMin*nums[i]);
            max = Math.max(max, dpMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,2,3,-5,-2};
        System.out.println(maxProduct(nums));
    }
}
