package nextGreaterElement2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2022/7/3 下午1:21
 */
public class Solution {

    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b-a);
        int idx = cs.length - 1;
        pq.offer(cs[idx--]);
        StringBuilder sb = new StringBuilder();
        while (idx >= 0) {
            if (cs[idx] < pq.peek()) {
                for (int i = 0; i < idx; i++) {
                    sb.append(cs[i]);
                }
                pq.offer(cs[idx]);
                StringBuilder tmp = new StringBuilder();
                while (!pq.isEmpty() && pq.peek() > cs[idx]) tmp.append(pq.poll());
                sb.append(tmp.charAt(tmp.length()-1));
                tmp.deleteCharAt(tmp.length()-1);
                while (!pq.isEmpty()) tmp.append(pq.poll());
                long ret = Long.parseLong(sb.append(tmp.reverse()).toString());
                return ret <= Integer.MAX_VALUE ? (int)ret : -1;
            }
            pq.offer(cs[idx--]);
        }
        return -1;
    }

    public int helper (int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length;

        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (cs[i] < cs[j]) {
                    int idx = j;
                    char it = cs[j];
                    for (int k = n-1; k >= i + 1; k--) {
                        if (cs[k] > cs[i] && cs[k] < it) {
                            idx = k;
                            it = cs[k];
                        }
                    }
                    char tmp = cs[idx];
                    cs[idx] = cs[i];
                    cs[i] = tmp;
                    Arrays.sort(cs, i + 1, n);
                    long res = Long.parseLong(new String(cs));
                    return res > Integer.MAX_VALUE ? -1 : (int)res;
                }
            }
        }
        return -1;
    }

}
