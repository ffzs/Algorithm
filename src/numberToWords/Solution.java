package numberToWords;

/**
 * @author: ffzs
 * @Date: 2021/10/11 上午6:55
 */
public class Solution {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1_000_000_000; i >= 0; i--, unit /= 1000) {
            int cur = num / unit;
            if (cur != 0) {
                num -= cur * unit;
                StringBuilder curSb = new StringBuilder();
                num2English(curSb, cur);
                curSb.append(thousands[i]).append(" ");
                sb.append(curSb);
            }
        }
        return sb.toString().trim();
    }

    private void num2English(StringBuilder sb, int num) {
        if (num == 0) return;
        else if (num < 10) sb.append(singles[num]).append(" ");
        else if (num < 20) sb.append(teens[num-10]).append(" ");
        else if (num < 100) {
            sb.append(tens[num/10]).append(" ");
            num2English(sb, num % 10);
        }
        else {
            sb.append(singles[num/100]).append(" Hundred ");
            num2English(sb, num % 100);
        }
    }

}
