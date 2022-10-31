package magicalString;

/**
 * @author: ffzs
 * @Date: 2022/10/31 下午1:47
 */
public class Solution {

    public int magicalString(int n) {
        if (n < 4) return 1;
        int[] infos = new int[n];
        infos[2] = 2;
        int i = 2, j = 3, len, num, res = 0;
        while (j < n) {
            len = infos[i];
            num = infos[j - 1];
            while (len > 0 && j < n) {
                infos[j++] = num;
                if (num == 1) res += 1;
                len--;
            }
            i += 1;
        }
        return res;
    }

}
