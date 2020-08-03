package addStrings;

/**
 * @author: ffzs
 * @Date: 2020/8/3 上午8:20
 */
public class Solution {

    public static String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        char[] addChar = new char[len1];

        int carry = 0;

        for (int i = 0; i < len1; i++) {
            int n1 = num1.charAt(len1-1-i)-'0';
            int n2 = i < len2?num2.charAt(len2-1-i)-'0':0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            addChar[i] = (char)(sum % 10 + '0');
        }

        StringBuilder sb = new StringBuilder();
        if (carry == 1) sb.append('1');
        for (int i = addChar.length - 1; i >= 0; i--) {
            sb.append(addChar[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "1111";
        System.out.println(addStrings(num1, num2));
    }
}
