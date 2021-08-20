package compress;

/**
 * @author: ffzs
 * @Date: 2021/8/21 上午7:02
 */
public class Solution {

    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        while (i < n) {
            int j = i, c = 1;
            while (i + 1 < n && chars[j] == chars[i + 1]) {
                chars[i+1] = 0;
                i++;
                c++;
            }
            if (c > 1) digitLen(c, chars, j + 1);
            System.out.println(chars);
            i++;
        }
        i = 0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != 0) {
                chars[i++] = chars[j];
            }
        }

        return i;
    }

    private void digitLen(int num, char[] chars, int idx) {
        for (char c : String.valueOf(num).toCharArray()) {
            chars[idx++] = c;
        }
    }

}
