package leastInterval;

/**
 * @author: ffzs
 * @Date: 2020/12/5 下午6:21
 */
public class Solution2 {

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char c : tasks) {
            counter[c-'A']++;
        }
        int max = 0;
        for (int i : counter) {
            max = Math.max(max, i);
        }
        int maxNum = 0;
        for (int i : counter) {
            if (i == max) maxNum++;
        }
        return Math.max((n+1)*(max-1)+maxNum, tasks.length);
    }
}
