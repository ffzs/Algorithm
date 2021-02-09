package subarraysWithKDistinct;

/**
 * @author: ffzs
 * @Date: 2021/2/9 上午8:15
 */
public class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysUnderKDistinct(A, K) - subarraysUnderKDistinct(A, K - 1);
    }

    private int subarraysUnderKDistinct(int[] A, int K){
        int n = A.length;
        int left = 0, right = 0;
        int count = 0, res = 0;
        int[] counter = new int[n + 1];

        while (right < n) {
            if (counter[A[right]] == 0) count++;
            counter[A[right]]++;
            right++;

            while (count > K) {
                counter[A[left]]--;
                if (counter[A[left]] == 0) count--;
                left++;
            }
            res += right - left;
        }
        return res;
    }

}
