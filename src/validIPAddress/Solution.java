package validIPAddress;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/29 上午8:46
 */
public class Solution {

    public String validIPAddress(String queryIP) {
        int dot = 0,  colon = 0;
        for (char c : queryIP.toCharArray()) {
            if (c == '.') ++dot;
            else if (c == ':') ++colon;
        }

        if (dot == 3 && colon == 0) {
            String[] v4 = queryIP.split("\\.");
            if (v4.length != 4) return "Neither";
            boolean isValid = true;
            for (String s : v4) {
                if (!isIPv4(s)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return "IPv4";
        }
        else if (dot == 0 && colon == 7) {
            String[] v6 = queryIP.split(":");
            if (v6.length != 8) return "Neither";
            boolean isValid = true;
            for (String s : v6) {
                if (!isIPv6(s)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return "IPv6";
        }

        return "Neither";
    }

    private boolean isIPv4 (String s) {
        if (s.length() > 3 || s.length() < 1) return false;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        int it = Integer.parseInt(s);
        if (it > 255 || it < 0) return false;
        return s.equals(String.valueOf(it));
    }

    private boolean isIPv6 (String s) {
        if (s.length() > 4 || s.length() < 1) return false;
        for (char c : s.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) return false;
        }
        return true;
    }

}

class Test{
    public static void main(String[] args) {
        String ip = "1.0.0.";
        Solution s = new Solution();
        System.out.println(s.validIPAddress(ip));
    }
}
