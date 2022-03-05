package findLUSlength;

/**
 * @author: ffzs
 * @Date: 2022/3/5 上午7:57
 */
public class Solution {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        else return Math.max(a.length(), b.length());
    }

}
