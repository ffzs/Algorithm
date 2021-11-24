package poorPigs;

/**
 * @author: ffzs
 * @Date: 2021/11/25 上午7:31
 */
public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest/minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(n));
    }

}
