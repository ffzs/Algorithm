package reverseStr;

/**
 * @author: ffzs
 * @Date: 2021/8/20 上午6:52
 */
public class Solution {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        for (int a = 0; a < n; a += 2*k) {
            int i = a;
            int j = Math.min(i+k-1, n-1);
            System.out.println(i+":"+j);
            while (i < j) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(cs);
    }

}
