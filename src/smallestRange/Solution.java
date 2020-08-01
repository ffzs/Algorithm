package smallestRange;

import java.util.*;


/**
 * @author ffzs
 * @describe
 * @date 2020/8/1
 */

public class Solution {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        if (n == 0) return new int[2];
        // 记录列表们中指针位置
        int[] idxes = new int[n];
        // 通过堆记录目前所有列表中最小值位置
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> nums.get(i).get(idxes[i])));

        int max = Integer.MIN_VALUE;
        // 获得初始最大和最小
        for (int i = 0; i < n; i++) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        int min = nums.get(queue.peek()).get(0);
        int[] res = {min, max};
        int range = max - min;
        while (true) {
            int minL = queue.poll();
            // 获取堆中最小值
            min = nums.get(minL).get(idxes[minL]);
            // 判断区间大小，以更换区间
            if (max - min < range) {
                range = max - min;
                res = new int[]{min, max};
            }
            // 最小值指针右移
            idxes[minL] ++;
            // 如果某个列表数据取完，那么结束循环
            if (idxes[minL] == nums.get(minL).size()) break;
            // 更新堆中排序
            queue.offer(minL);
            // 更新最大值
            max = Math.max(max, nums.get(minL).get(idxes[minL]));
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
