package convertToTitle;

/**
 * @author: ffzs
 * @Date: 2021/6/29 上午6:54
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber >= 1) {
            int x = (columnNumber - 1)%26 + 1;
            sb.append((char)(x - 1 + 'A'));
            columnNumber = (columnNumber - x) / 26;
        }

        return sb.reverse().toString();
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(701));
    }
}
