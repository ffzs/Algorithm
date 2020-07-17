package countSmaller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/11
 */
public class Solution2 {
    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();
        int[] counter = new int[len];
        List<Integer> sorted = new ArrayList<>();
        sorted.add(nums[len-1]);
        for (int i = len-2; i >=0 ; --i) {
            int index = findIndex(nums[i], sorted);
            sorted.add(index, nums[i]);
            counter[i] = index;
        }
        List<Integer> res = new ArrayList<>(len);
        for (int i : counter) res.add(i);
        return res;
    }

    private static int findIndex (int num, List<Integer> sorted) {
        int l = 0, r = sorted.size()-1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (sorted.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        return sorted.get(l) < num ? l + 1: l;
    }

    public static void main(String[] args) {
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(countSmaller(nums));
    }
}
