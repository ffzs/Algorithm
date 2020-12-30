package lastStoneWeight;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/30 上午8:14
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 1) return stones[0];
        Arrays.sort(stones);
        while (stones[n-2] != 0) {
            stones[n-2] = stones[n-1] - stones[n-2];
            stones[n-1] = 0;
            Arrays.sort(stones);
        }
        return stones[n-1];
    }
}

class Test {
    public static void main(String[] args) {
        int[] stones = {316,157,73,106,771,828,46,212,926,604,600,992,71,51,477,869,425,405,859,924,45,187,283,590,303,66,508,982,464,398};
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(stones));
    }
}
