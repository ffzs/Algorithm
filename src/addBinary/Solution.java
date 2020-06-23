package addBinary;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/23
 */
public class Solution {
    public static String addBinary(String a, String b) {
        char[] aChar, bChar;
        int len = Math.max(a.length(), b.length());
        if (a.length() > b.length()) {
            aChar = a.toCharArray();
            bChar = charList(b, a.length() - b.length(), len);
        }
        else if (a.length() == b.length()) {
            aChar = a.toCharArray();
            bChar = b.toCharArray();
        }
        else{
            bChar = b.toCharArray();
            aChar = charList(a, b.length() - a.length(), len);
        }

        char[] res = new char[len];
        int next = 0;
        for (int i = len-1; i >= 0; --i) {
            int sum = aChar[i] + bChar[i] + next - 2 * '0';
            res[i] = (char)(sum % 2 + '0');
            next = sum / 2;
        }
        StringBuilder sb = new StringBuilder();
        if (next == 1) sb.append('1');
        sb.append(res);
        return sb.toString();
    }

    private static char[] charList (String s, int start, int len) {
        char[] seq = new char[len];
        for (int i = 0; i < len; i++) {
            if (i < start) seq[i] = '0';
            else seq[i] = s.charAt(i-start);
        }
        return seq;
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }
}
