package smallestRange;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/8/1
 */
public class Solution3 {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int len = nums.stream().mapToInt(List::size).sum();
        int[][] ns = new int[len][2];
        int i = 0, j = 0;
        for(List<Integer> list : nums){
            for(Integer num : list){
                ns[i][0] = num;
                ns[i][1] = j;
                i++;
            }
            j++;
        }

        Arrays.sort(ns,Comparator.comparingInt(v -> v[0]));  // 重新排序

        int[] res = new int[]{ns[0][0], ns[len-1][0]};
        int l=0, r=0, k=0;
        int[] counter = new int[n];
        int range = res[1] - res[0];
        while (r < len) {
            if (counter[ns[r][1]]++ == 0) k++;
            if (k == n) {
                while (counter[ns[l][1]] > 1) counter[ns[l++][1]]--;  // 跳过最小值所在列表中值不唯一情况
                int curRange = ns[r][0] - ns[l][0];
                if (curRange < range || (curRange == range && ns[l][0] < res[0])) {
                    range = curRange;
                    res = new int[] {ns[l][0], ns[r][0]};
                }
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4,10,15,24,26));
        nums.add(List.of(0,9,12,20));
        nums.add(List.of(5,18,22,30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}
