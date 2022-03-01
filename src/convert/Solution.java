package convert;

/**
 * @author: ffzs
 * @Date: 2022/3/1 上午8:08
 * p   a   h
 * a p l s
 * y   i
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int n = numRows * 2 - 2;
        int[] idxes = new int[n];
        int j = 0;
        for (int i = 0; i < numRows; i++) {
            idxes[j++] = i;
        }

        for (int i = numRows - 2; i > 0; --i) {
            idxes[j++] = i;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            sbs[idxes[i%n]].append(s.charAt(i));
        }

        for (int i = 1; i < numRows; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }

}
