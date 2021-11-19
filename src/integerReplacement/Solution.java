package integerReplacement;

/**
 * @author: ffzs
 * @Date: 2021/11/19 上午7:33
 */
public class Solution {
    public int integerReplacement(int m) {
        int cnt = 0;
        long n = m;
        while (n > 1) {
            if ((n & 1) == 1) {
                if (helper(n) >= helper(n + 1) + 1) n++;
                cnt ++;
            }
            cnt ++;
            n >>= 1;
        }
        return cnt;
    }

    private int helper(long n){
        int cnt = 0;
        while (n > 1) {
            cnt += n & 1;
            n >>= 1;
            cnt ++;
        }
        return cnt;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerReplacement(100000000));
    }
}
