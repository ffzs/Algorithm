package findOcurrences;

/**
 * @author: ffzs
 * @Date: 2021/12/26 上午7:36
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int n = words.length;
        int[] tmp = new int[n];
        int j = 0;
        for (int i = 2; i < n; i++) {
            if (words[i-2].equals(first) && words[i-1].equals(second)) tmp[j++] = i;
        }
        String[] res = new String[j];
        for (int i = 0; i < j; i++) {
            res[i] = words[tmp[i]];
        }
        return res;
    }
}
