package arrayStringsAreEqual;

/**
 * @author: ffzs
 * @Date: 2022/11/1 上午9:13
 */
public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.length() == sb2.length() && sb1.toString().equals(sb2.toString());
    }

}
