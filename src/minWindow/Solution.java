package minWindow;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/23
 */

public class Solution {
    public String minWindow(String s, String t) {
        char[] scr = s.toCharArray(), tcr = t.toCharArray();
        int min = scr.length + 1, left = 0, right = 0, res = 0, count = tcr.length;
        int[] ori = new int[128];
        for (char c : tcr) ori[c]++;
        while (right < scr.length) {
            if (ori[scr[right]] > 0) {
                count--;
            }
            ori[scr[right]]--;
            right++;

            while (count == 0) {
                ori[scr[left]]++;
                if (ori[scr[left]] > 0) {
                    if (right - left < min) {
                        min = right - left;
                        res = left;
                    }
                    count++;
                }
                left++;
            }
        }
        return  min==scr.length+1? "" : s.substring(res, res + min);
    }
}

class test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "aancc";
        String t = "ca";
        System.out.println(sl.minWindow(s, t));
    }
}