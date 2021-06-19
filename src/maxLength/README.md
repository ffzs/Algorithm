## 1239. 串联字符串的最大长度

## 题目

给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

请返回所有可行解 s 中最长长度。

```java
示例 1：

输入：arr = ["un","iq","ue"]
输出：4
解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
示例 2：

输入：arr = ["cha","r","act","ers"]
输出：6
解释：可能的解答有 "chaers" 和 "acters"。
示例 3：

输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
输出：26
```

```java
提示：

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] 中只含有小写英文字母
```


链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

## 解题记录

+ 因为是通过26个字母组成，而且只讨论重复与否的问题，因此我们可以通过一个数值来记录字母状态
+ 然后通过回溯的方法通过&判断是否有相同的字符

```java
/**
 * @author: ffzs
 * @Date: 2021/6/19 上午9:20
 */
public class Solution {

    int res = 0;
    List<Integer> masks;
    int n;

    public int maxLength(List<String> arr) {
        masks = new ArrayList<>();

        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int cc = c - 'a';
                if (((mask >> cc) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << cc;
            }
            if (mask > 0) masks.add(mask);
        }
        n = masks.size();
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int mask) {
        if (index == n) {
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }

        if ((mask & masks.get(index)) == 0) dfs(index + 1, mask | masks.get(index));
        dfs(index + 1, mask);
    }
}
```

![image-20210619105209949](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210619105209949.png)