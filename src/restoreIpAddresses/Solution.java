package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/9 上午7:33
 */


public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int i = 1, j, k;
        while (i<=3){
            j = i + 1;
            while (j-i>0 && j-i<=3 && j < s.length() -1) {
                k = j+1;
                while (k-j >0 && k-j <=3 && k < s.length()) {
                    String ret = isNum(s, i, j, k);
                    if (!ret.equals("")) result.add(ret);
                    k++;
                }
                j++;
            }
            i++;
        }
        return result;
    }

    private String isNum (String s, int i, int j, int k) {
        if (s.length()-1 - k > 3) return "";
        String s1 = s.substring(0,i);
        String s2 = s.substring(i,j);
        String s3 = s.substring(j,k);
        String s4 = s.substring(k);
        System.out.println(s1 + "." + s2 + "." + s3 + "." + s4);
        if (ifBetween(s1) && ifBetween(s2) && ifBetween(s3) && ifBetween(s4)) {
            return s1 + "." + s2 + "." + s3 + "." + s4;
        }
        return "";
    }

    private boolean ifBetween (String it) {
        if (it.equals("") || it.length() > 3) return false;
        if (it.length() > 1 && it.charAt(0) == '0') return false;
        if (it.length() == 3) return Integer.parseInt(it) <= 255;
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0000";
        System.out.println(solution.restoreIpAddresses(s));
    }
}
