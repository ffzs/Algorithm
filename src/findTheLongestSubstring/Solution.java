package findTheLongestSubstring;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe 1371. 每个元音包含偶数次的最长子字符串
 *
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 *
 * 示例 1：
 * 输入：s = "eleetminicoworoep"
 * 输出：13
 * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
 *
 * 示例 2：
 * 输入：s = "leetcodeisgreat"
 * 输出：5
 * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
 *
 * 示例 3：
 * 输入：s = "bcbcbc"
 * 输出：6
 * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
 *
 * 提示：
 *
 * 1 <= s.length <= 5 x 10^5
 * s 只包含小写英文字母。
 *
 * @date 2020/5/20
 */
public class Solution {
    public static int findTheLongestSubstring(String s) {
        // 创建数组记录出现奇偶情况
        int[] tmp = new int[1<<5], letter = new int[26];
        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowel.length; i++) {
            letter[vowel[i]-'a'] = 1<<i;
        }
        tmp[0] = 1;
        char[] seq = s.toCharArray();
        int status = 0, res=0, m=-1;
        for (int i = 0; i < s.length(); i++) {
            int index = seq[i] - 'a';
            status ^= letter[index];
            // 因为偶数-偶数=偶数， 奇数-奇数=偶数，因此只要status以前出现过，那么就是中间这段为偶数
            if (tmp[status] != 0) {
                res = Math.max(res, i-tmp[status]+2);
            }else{
                tmp[status] = i+2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        System.out.println(findTheLongestSubstring(s));
    }
}





