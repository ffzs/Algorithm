package decodeString;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ffzs
 * @describe 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @date 2020/5/28
 */
public class Solution {
    static int i = 0;
    public static String decodeString(String s) {
        return unzip(s).toString();
    }
    private static StringBuilder unzip (String s) {
        // 递归
        int num = 0;
        StringBuilder str = new StringBuilder();

        while (i < s.length()) {
            if (s.charAt(i) == ']') {
                return str;
            }
            else if (s.charAt(i) == '[') {
                i++;
                StringBuilder sub = unzip(s);
                do {str.append(sub);} while (--num > 0);
            }
            else if (Character.isDigit(s.charAt(i))) {
                num = num*10 + s.charAt(i) - '0';
            }
            else str.append(s.charAt(i));
            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        String minTime = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        System.out.println(minTime);
        String s = "3[a]2[b4[F]c]";
        System.out.println(decodeString(s));
        System.out.println(i);
    }
}
