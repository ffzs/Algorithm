package backspaceCompare;

/**
 * @author: ffzs
 * @Date: 2020/10/19 上午8:47
 */

public class Solution {

    public boolean backspaceCompare(String S, String T) {
        return deal(S).toString().equals(deal(T).toString());
    }

    private StringBuilder deal (String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (sb.length()>0) sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(str.charAt(i));
        }
        System.out.println(sb);
        return sb;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
//        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));

    }
}
