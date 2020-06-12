package reversePaires;


import java.util.Arrays;

public class reversePaires {
    public static int reversePairs(int[] nums){
        int len = nums.length;
        if (len<2) return 0;
        int[] tmp = new int[len];
        return split(nums, 0, len-1, tmp);
    }

    private static int split(int[] nums, int start, int end, int[] tmp) {
        if(start==end) return 0;
        int mid = (start+end)>>1;
        int leftCount = split(nums, start, mid, tmp);
        int rightCount = split(nums, mid+1, end, tmp);
        if(nums[mid] <= nums[mid+1]) return leftCount+rightCount;
        int mixCount = merge(nums, start, mid, end, tmp);
        return leftCount+mixCount+rightCount;
    }

    private static int merge(int[] nums, int start, int mid, int end, int[] tmp) {
        System.arraycopy(nums, start, tmp, start, end + 1 - start);
        int idx1 = start, idx2 = mid+1;
        int count=0;
        for (int i=start; i<=end; ++i){
            if( idx1 > mid ){
                nums[i] = tmp[idx2];
                ++idx2;
            } else if (idx2 > end) {
                nums[i] = tmp[idx1];
                ++idx1;
            } else if (tmp[idx1] <= tmp[idx2]) {
                nums[i] = tmp[idx1];
                ++idx1;
            } else {
                nums[i] = tmp[idx2];
                ++idx2;
                count += (mid+1-idx1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
}
