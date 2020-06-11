package jump;

public class jump {
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len<=1) return 0;
        int max=nums[0], step=1, index=1;
        while (max<len-1) {
            int tmp = max;
            for (int i=index;i<=tmp;++i){
                max = Math.max(nums[i]+i, max);
            }
            index=tmp+1;
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,3,2,5,4,3};
        System.out.println(jump(nums));
    }
}
