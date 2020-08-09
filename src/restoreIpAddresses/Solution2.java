package restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/9 上午8:29
 */
public class Solution2 {
    private List<String> res;
    private char[] chars, tmp;
    private int n;
    public List<String> restoreIpAddresses(String s) {
        chars = s.toCharArray();
        res = new ArrayList<String>();
        n = chars.length;
        tmp = new char[n+3]; // 三个'.' 的位置
        backtrace(0,0);
        return res;
    }

    private void backtrace(int i, int level) {
        if (n - i < 4 - level || n - i > (4-level) * 3) return;

        if (level == 4) {
            res.add(new String(tmp));
            return;
        }

        if (level > 0) tmp[i+level-1] = '.'; // 每一层添加 .
        // 1位数值
        tmp[i + level] = chars[i];
        backtrace(i+1, level +1);

        // 2位数值
        if (chars[i] == '0' || i >= n-1) return; // 2位数不能以 0开头例如：01应为1
        tmp[i+level+1] = chars[i+1];
        backtrace(i+2, level+1);

        // 3为数值
        if(i+2 < n && (chars[i]-'0')*100 + (chars[i+1]-'0')*10 + (chars[i+2]-'0') <=255) {
            tmp[i+level+2] = chars[i+2];
            backtrace(i+3, level+1);
        }
    }
}
