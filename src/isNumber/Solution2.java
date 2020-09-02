package isNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/9/2 上午9:23
 * <p>
 * 字符类型：
 * 0~9  ->NUM -> n
 * +，-  ->SIGN ->s
 * .    -> DOT ->d
 * e,E  ->EXP ->e
 * ' '  ->BLANK ->b
 * <p>
 * 状态：
 * 0：起始的空格
 * 1：符号位
 * 2：整数部分
 * 3：左侧有整数的小数点
 * 4：左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
 * 5：小数部分
 * 6：字符 e
 * 7：指数部分的符号位
 * 8：指数部分的整数部分
 * 9：末尾的空格
 */

public class Solution2 {
    public boolean isNumber(String s) {
        Map[] states = {
                //0：起始的空格
                new HashMap<>() {{
                    put('b', 0);
                    put('d', 4);
                    put('s', 1);
                    put('n', 2);
                }},
                //1：符号位
                new HashMap<>() {{
                    put('d', 4);
                    put('n', 2);
                }},
                //2：整数部分
                new HashMap<>() {{
                    put('n', 2);
                    put('e', 6);
                    put('b', 9);
                    put('d', 3);
                }},
                //3：左侧有整数的小数点
                new HashMap<>() {{
                    put('n', 5);
                    put('b', 9);
                    put('e', 6);
                }},
                //4：左侧无整数的小数点（根据前面的第二条额外规则，需要对左侧有无整数的两种小数点做区分）
                new HashMap<>() {{
                    put('n', 5);
                }},
                //5：小数部分
                new HashMap<>() {{
                    put('n', 5);
                    put('b', 9);
                    put('e', 6);
                }},
                //6：字符 e
                new HashMap<>() {{
                    put('s', 7);
                    put('n', 8);
                }},
                //7：指数部分的符号位
                new HashMap<>() {{
                    put('n', 8);
                }},
                //8：指数部分的整数部分
                new HashMap<>() {{
                    put('n', 8);
                    put('b', 9);
                }},
                //9：末尾的空格
                new HashMap<>() {{
                    put('b', 9);
                }},
        };

        int i = 0;
        char type;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                    type = 's';
                    break;
                case 'e':
                case 'E':
                    type = 'e';
                    break;
                case '.':
                    type = 'd';
                    break;
                case ' ':
                    type = 'b';
                    break;
                default:
                    if (c >= '0' && c <= '9') type = 'n';
                    else return false;
            }
            if (!states[i].containsKey(type)) return false;
            i = (int) states[i].get(type);
        }
        return i == 2 || i == 3 || i == 5 || i == 8 || i == 9;
    }
}
