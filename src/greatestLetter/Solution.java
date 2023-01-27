package greatestLetter;

/**
 * @author: ffzs
 * @Date: 2023/1/27 下午1:38
 */
public class Solution {

    public String greatestLetter(String s) {
        char[] cs = s.toCharArray();

        for (char i = 'Z'; i >= 'A'; i--) {
            if (s.indexOf(i) > -1 && s.indexOf(i + 32) > -1)
                return new StringBuilder().append(i).toString();
        }
        return "";
    }

}
