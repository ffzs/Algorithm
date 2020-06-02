package sumNums;

/**
 * @author ffzs
 * @describe 面试题64. 求1+2+…+n
 * @date 2020/6/2
 */
public class Solution {
    public static int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) != 0;
        return n;
    }
}
