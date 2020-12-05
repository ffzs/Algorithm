package leastInterval;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/5 下午5:05
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] tmp = new int[26];
        int count = 0;
        for (char c : tasks) {
            if (tmp[c - 'A'] == 0) count++;
            tmp[c - 'A']++;
        }
        Arrays.sort(tmp);
        int[] counter = new int[count];
        for (int i = 0; i < counter.length; i++) {
            counter[counter.length-i-1] = tmp[25-i];
        }
        int i = 0, res = 0, j = 0;
        while (i < tasks.length) {
            int k = counter.length-1;
            j = 0;
            while (j <= n && k >=0) {
                if (counter[k] > 0) {
                    counter[k]--;
                    j++;
                    i++;
                }
                k--;
            }
            if (k >= 0 && counter[k]>counter[k+1]) Arrays.sort(counter);
            res += n-j+1;
        }
        return res+tasks.length-n+j-1;
    }

}

class Test{
    public static void main(String[] args) {
//        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(tasks, 2));
    }
}
