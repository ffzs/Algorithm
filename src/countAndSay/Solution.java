package countAndSay;

/**
 * @author: ffzs
 * @Date: 2021/10/15 上午7:08
 */
public class Solution {

    public String countAndSay(int n) {
        return subCount("1", n);
    }

    private String subCount(String s, int n) {
        if (n == 1) return s;
        char[] cs = s.toCharArray();
        StringBuilder ret = new StringBuilder();
        char part = cs[0];
        int cnt = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == part) cnt++;
            else {
                ret.append(cnt).append(part);
                part = cs[i];
                cnt = 1;
            }
        }
        ret.append(cnt).append(part);
        return subCount(ret.toString(), n - 1);
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
    }
}
