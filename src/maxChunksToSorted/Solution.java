package maxChunksToSorted;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/8/13 上午10:13
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 0) map.remove(arr[i]);
            map.put(tmp[i], map.getOrDefault(tmp[i], 0) - 1);
            if (map.get(tmp[i]) == 0) map.remove(tmp[i]);
            if (map.size() == 0) {
                res += 1;
            }
        }
        return res;
    }

    public int maxChunksToSorted2(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i : arr) {
            if (!stack.isEmpty() && i < stack.peek()) {
                int l = stack.pop();
                while (!stack.isEmpty() && i < stack.peek()) stack.pop();
                stack.push(l);
            }
            else stack.push(i);
        }
        return stack.size();
    }


}
