package numRabbits;

/**
 * @author: ffzs
 * @Date: 2021/4/4 下午12:32
 */
public class Solution {

    public int numRabbits(int[] answers) {
        int[] counter = new int[999];
        for (int answer : answers) {
            counter[answer]++;
        }

        int res = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                int cur = counter[i];
                res += (cur%(i+1) == 0?cur/(i+1):cur/(i+1)+1)*(i+1);
            }
        }
        return res;
    }
}
