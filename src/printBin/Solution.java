package printBin;

/**
 * @author: ffzs
 * @Date: 2023/3/2 上午6:36
 */
public class Solution {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder().append("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            sb.append((int)num);
            num -= (int)num;
        }
        return sb.length() > 32 ? "ERROR" : sb.toString();
    }

}
