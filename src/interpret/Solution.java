package interpret;

/**
 * @author: ffzs
 * @Date: 2022/11/6 下午1:57
 */
public class Solution {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i += 1;
            }
            else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            }
            else {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

}
