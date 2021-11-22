package shuffleArray;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/11/22 上午7:45
 */
public class Solution {
    int[] nums;
    int[] copy;
    int n;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.copy = nums.clone();
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < n; i++) {
            swap(i, random.nextInt(n));
        }
        return copy;
    }

    private void swap(int i, int j) {
        int tmp = copy[i];
        copy[i] = copy[j];
        copy[j] = tmp;
    }

}
