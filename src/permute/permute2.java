package permute;

import java.util.ArrayList;
import java.util.List;

public class permute2 {
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private static void backtrack(int[] nums, int index) {
        if (index == nums.length){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            result.add(tmp);
            return;
        }

        for(int i=index; i<nums.length; ++i){
            swap(nums, index, i);
            backtrack(nums, index+1);
            swap(nums, i, index);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int a=nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
