package isNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/9/2 上午7:45
 */

public class Solution {
    boolean haveE =  false;
    boolean isFloat = false;
    boolean haveSymbol = false;
    boolean haveNumber = false;
    public boolean isNumber(String s) {
        char[] seq = s.toCharArray();
        int i = 0;

        while (i < seq.length) {
            System.out.println(seq[i]);
            switch (seq[i]) {
                // 空值在前面的话直接跳过， 在后面的话循环之后
                case ' ':
                    if (i==0) {
                        if (haveE) return false;
                        while (i<seq.length && seq[i]==' ') i++;
                        break;
                    }
                    else {
                        while (i<seq.length && seq[i]==' ') i++;
                        if (i!=seq.length) return false;
                        break;
                    }
                    // 之前不能有数组和小数点
                case '-':
                case '+':
                    if (haveNumber||isFloat) return false;
                    haveSymbol = true;
                    i++; break;
                    // e之后的不能出现小数，已经有小数点的不能再出现小数点
                case '.':
                    if (haveE||isFloat) return false;
                    isFloat = true;
                    i++; break;
                    // 之前没有数字不行 刷新之前number和小数
                case 'e':
                case 'E':
                    if(haveE||!haveNumber) return false;
                    haveNumber=false;
                    isFloat=false;
                    haveE=true;
                    return isNumber(s.substring(i+1));
                default:
                    // 剩下的如果不是数字不行
                    if(isNum(seq[i])){
                        haveNumber = true;
                        i++; break;
                    }
                    else return false;
            }
        }
        // 整个字符必须有数字才能算数
        return haveNumber;
    }

    private boolean isNum (char c) {
        return c>='0' && c<='9';
    }
}

class Test {
    public static void main(String[] args) {
        String num = "32.e-80123";
        Solution solution = new Solution();
        System.out.println(solution.isNumber(num));
    }
}
