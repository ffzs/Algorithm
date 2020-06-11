package canJump;

public class canJump {
    public static boolean canJump(int[] nums) {
        // 双指针
        if (nums.length<=1) return true;
        int len = nums[nums.length-1] == 0?nums.length-1:nums.length;
        for(int i=0; i<len; ++i){
            marker:if(nums[i]==0){
                for (int j=i-1; j>=0; --j){
                    System.out.println(nums[j]);
                    if (nums[j]-(i-j)>0) break marker;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,0,1};
        System.out.println(canJump(nums));
    }
}
