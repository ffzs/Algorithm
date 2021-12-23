package longestDupSubstring;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/23 上午11:34
 */

class SufStr {
    private String s;
    private int n, m;
    int[] c, x, y, sa, rk, height;
    public SufStr(int m_, String s_) {
        s = " " + s_;
        n = s_.length();
        m = m_;
        c = new int[m + n + 1];
        x = new int[n + 10];
        y = new int[n + 10];
        sa = new int[n + 10];
        rk = new int[n + 10];
        height = new int[n + 10];
    }

    private static void swap (int[] a, int[] b) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            tmp = a[i];
            a[i] = b[i];
            b[i] = tmp;
        }
    }

    public void getSa() {
        for (int i = 1; i <= n; i++) {
            x[i] = s.charAt(i);
            c[x[i]]++;
        }

        for (int i = 2; i <= m; i++) c[i] += c[i-1];
        for (int i = n; i > 0; i--) sa[c[x[i]]--] = i;
        for (int k = 1; k <= n; k <<= 1) {
            int num = 0;
            for (int i = n - k + 1; i <= n; i++) y[++num] = i;
            for (int i = 1; i <= n; i++) if (sa[i] > k) y[++num] = sa[i] - k;

            for (int i = 1; i <= m; i++) c[i] = 0;
            for (int i = 1; i <= n; i++) c[x[i]]++;
            for (int i = 2; i <= m; i++) c[i] += c[i-1];
            for (int i = n; i > 0; i--) {
                sa[c[x[y[i]]]--] = y[i];
                y[i] = 0;
            }

            swap(x, y);

            x[sa[1]] = 1;
            num = 1;
            for (int i = 2; i + k <= n; i++) {
                if (y[sa[i]] == y[sa[i - 1]] && sa[i] + k <= n && sa[i - 1] + k <= n && y[sa[i] + k] == y[sa[i - 1] + k])
                    x[sa[i]] = num;
                else x[sa[i]] = ++num;
            }

            if (num == n) break;
            m = num;
        }
    }

    public void getHeight() {
        for (int i = 1; i <= n; i++) rk[sa[i]] = i;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            if (rk[i] == 1) continue;
            if (k > 0) k --;
            int j = sa[rk[i] - 1];
            while (i + k <= n && j + k <= n && s.charAt(i + k) == s.charAt(j + k)) k++;
            height[rk[i]] = k;
        }

    }
}
public class Solution2 {
    public String longestDupSubstring(String s) {
        SufStr ss = new SufStr('z', s);
        ss.getSa();
        ss.getHeight();
        int max = 0;
        int idx = -1;
        for (int i = 1; i <= s.length(); i++) {
            if (ss.height[i] > max) {
                max = ss.height[i];
                idx = ss.sa[i];
            }
        }
        if (max == 0) return "";
        else return s.substring(idx - 1, idx - 1 + max);
    }
}


class Test1 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.longestDupSubstring("ababdaebdabedeabbdddbcebaccececbccccebbcaaabaadcadccddaedaacaeddddeceedeaabbbbcbacdaeeebaabdabdbaebadcbdebaaeddcadebedeabbbcbeadbaacdebceebceeccddbeacdcecbcdbceedaeebdaeeabccccbcccbceabedaedaacdbbdbadcdbdddddcdebbcdbcabbebbeabbdccccbaaccbbcecacaebebecdcdcecdeaccccccdbbdebaaaaaaeaaeecdecedcbabedbabdedbaebeedcecebabedbceecacbdecabcebdcbecedccaeaaadbababdccedebeccecaddeabaebbeeccabeddedbeaadbcdceddceccecddbdbeeddabeddadaaaadbeedbeeeaaaeaadaebdacbdcaaabbacacccddbeaacebeeaabaadcabdbaadeaccaecbeaaabccddabbeacdecadebaecccbabeaceccaaeddedcaecddaacebcaecebebebadaceadcaccdeebbcdebcedaeaedacbeecceeebbdbdbaadeeecabdebbaaebdddeeddabcbaaebeabbbcaaeecddecbbbebecdbbbaecceeaabeeedcdecdcaeacabdcbcedcbbcaeeebaabdbaadcebbccbedbabeaddaecdbdbdccceeccaccbdcdadcccceebdabccaebcddaeeecddddacdbdbeebdabecdaeaadbadbebecbcacbbceeabbceecaabdcabebbcdecedbacbcccddcecccecbacddbeddbbbadcbdadbecceebddeacbeeabcdbbaabeabdbbbcaeeadddaeccbcdabceeabaacbeacdcbdceebeaebcceeebdcdcbeaaeeeadabbecdbadbebbecdceaeeecaaaedeceaddedbedbedbddbcbabeadddeccdaadaaeaeeadebbeabcabbdebabeedeeeccadcddaebbedadcdaebabbecedebadbdeacecdcaebcbdababcecaecbcbcdadacaebdedecaadbaaeeebcbeeedaaebbabbeeadadbacdedcbabdaabddccedbeacbecbcccdeaeeabcaeccdaaaddcdecadddabcaedccbdbbccecacbcdecbdcdcbabbeaacddaeeaabccebaaaebacebdcdcbbbdabadeebbdccabcacaacccccbadbdebecdaccabbecdabdbdaebeeadaeecbadedaebcaedeedcaacabaccbbdaccedaedddacbbbdbcaeedbcbecccdbdeddcdadacccdbcdccebdebeaeacecaaadccbbaaddbeebcbadceaebeccecabdadccddbbcbaebeaeadacaebcbbbdbcdaeadbcbdcedebabbaababaacedcbcbceaaabadbdcddadecdcebeeabaadceecaeccdeeabdbabebdcedceaeddaecedcdbccbbedbeecabaecdbba"));
    }
}