package addDigits;

/**
 * @author: ffzs
 * @Date: 2022/3/3 上午7:55
 */
public class Solution {

    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

}
