package search;

public class search {
    public static int search(int[] nums, int target) {
        int start=0, end=nums.length-1;
        while(start<end) {
            int mid=(start+end)>>1;
            if ((nums[0]>nums[mid])^(nums[0]>target)^(target>nums[mid])){
                start=mid+1;
            } else {
                end=mid;
            }
        }
        return ((start==end)&&(nums[start]==target))?start:-1;
    }
}
