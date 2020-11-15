package removeKdigits;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/15 上午10:06
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        char[] cs = num.toCharArray();
        char[] res = new char[num.length()-k];
        int idx = 0;
        res[0] = cs[0];
        for (int i = 1; i < cs.length; i++) {
            while (idx>=0 && k > 0 && res[idx] > cs[i]){
                idx--;
                k--;
            }
            if (idx < res.length-1) {
                res[++idx] = cs[i];
            }
            System.out.println(Arrays.toString(res) + "->" + cs[i] + " index:" + idx);
        }

        if (idx != res.length) res[idx] = cs[cs.length-1];
        int start = 0;
        while (start < res.length && res[start] == '0') start++;
        return start != res.length?new String(Arrays.copyOfRange(res, start, res.length)):"0";
    }
}

class Test {
    public static void main(String[] args) {
//        String num = "1432219";
        String num = "9999999999991";
        Solution2 solution = new Solution2();
        System.out.println(solution.removeKdigits(num, 8));
    }
}
