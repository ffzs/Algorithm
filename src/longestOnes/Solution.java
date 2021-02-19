package longestOnes;

/**
 * @author: ffzs
 * @Date: 2021/2/19 上午8:13
 */
public class Solution {

    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int res = 0, count = 0;
        int left = 0, right = 0;

        while (right < n) {
            if (count <= K) {
                if (A[right] == 0) count++;
                if (count <= K) res = Math.max(right - left + 1, res);
                right++;
            }
            else {
                if (A[left] == 0) count--;
                left++;
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
//        int[] A = {0,0,0,1};
        System.out.println(solution.longestOnes(A, 2));
    }
}
