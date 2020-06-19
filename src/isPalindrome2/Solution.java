package isPalindrome2;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/19
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        s = transString(s);
        int left = 0, right = s.length()-1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }

    private static String transString (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char it = s.charAt(i);
            if(it>='A' && it<='Z') {
                sb.append((char) (it-'A'+'a'));
            }
            else if((it>='a' && it<='z') || (it>='0'&&it<='9')) {
                sb.append(it);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
