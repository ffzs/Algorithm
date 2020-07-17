package intersect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/13
 */
public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums2.length > nums1.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Map<Integer, Integer> mL = getCountMap(nums1), mS = getCountMap(nums2);

        int counter = 0;
        for (Integer integer : mS.keySet()) {
            if (mL.containsKey(integer)) {
                int c = Math.min(mS.get(integer), mL.get(integer)) + counter;
                while (counter < c) res[counter++] = integer;
            }
        }
        return Arrays.copyOf(res, counter);
    }

    private static Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5},  nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
