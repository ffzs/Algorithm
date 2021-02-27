## [395. 至少有K个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/)

## 题目

找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。

```java
示例 1:

输入:
s = "aaabb", k = 3
输出:
3
最长子串为 "aaa" ，其中 'a' 重复了 3 次。

示例 2:
输入:
s = "ababbc", k = 2
输出:
5
最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
```


链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters

## 解题记录

+ 通过滑动窗口求解，首先获取字符串中出现过字符的频率
+ 然后根绝频率和k来判断一共有多少个字符t可以满足要求
+ 然后限定窗口中出现自字符个数为1-t来遍历所有情况
+ 同时记录窗口中个数少于k的字符个数，如果当前窗口中少于k的字符为0，那么符合条件

```java
/**
 * @author: ffzs
 * @Date: 2021/2/27 上午8:40
 */
public class Solution {

    public int longestSubstring(String s, int k) {

        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        int t = 0;
        for (char c : cs) {
            counter[c - 'a'] ++;
        }

        for (int i : counter) {
            if (i >= k) t++;
        }

        int res = 0;

        for (int i = 1; i <= t; i++) {
            int l = 0, r = 0;
            int[] tmp = new int[26];
            int tt = 0;
            int sub = 0;
            while (r < cs.length) {
                tmp[cs[r] - 'a'] ++;
                if (tmp[cs[r] - 'a'] == 1) {
                    tt++; sub++;
                }
                if (tmp[cs[r] - 'a'] == k) sub--;

                while (tt > i) {
                    tmp[cs[l] - 'a']--;
                    if (tmp[cs[l] - 'a'] == k-1) sub ++;
                    if (tmp[cs[l] - 'a'] == 0) {
                        tt --; sub--;
                    }
                    l++;
                }

                if (sub == 0) res = Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s= "aaabb";
        System.out.println(solution.longestSubstring(s, 3));
    }
}
```

![image-20210227100825587](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210227100825587.png)

+ 通过分治剪枝的方法
+ 获取字符串的字符频率，通过不满足要求的字符将字符串切割
+ 切割后的字符串递归处理

```java
/**
 * @author: ffzs
 * @Date: 2021/2/27 上午9:50
 */
public class Solution2 {

    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        return dfs(cs, 0, n-1, k);
    }

    private int dfs (char[] cs, int l, int r, int k) {
        int[] cnt = new int[26];

        for (int i = l; i <= r; i++) {
            cnt[cs[i] - 'a'] ++;
        }

        char pos = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                pos = (char)(i + 'a');
                break;
            }
        }

        if (pos == 0) return r - l + 1;

        int i = l, ret = 0;

        while (i < r) {
            while (i <= r && cs[i] == pos) i++;
            if (i > r) break;
            int start = i;
            while (i <= r && cs[i] != pos) i++;
            int gap = dfs(cs, start, i - 1, k);
            ret = Math.max(ret, gap);
        }
        return ret;
    }

}
```

![image-20210227101228152](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210227101228152.png)