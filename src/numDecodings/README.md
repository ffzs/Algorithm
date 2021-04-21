## 91. 解码方法

## 题目

一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。

给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。

 

```java
示例 1：
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
    
示例 2：
输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
    
示例 3：
输入：s = "0"
输出：0
解释：没有字符映射到以 0 开头的数字。
含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
    
示例 4：
输入：s = "06"
输出：0
解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
```



```java
提示：

1 <= s.length <= 100
s 只包含数字，并且可能包含前导零
```



链接：https://leetcode-cn.com/problems/decode-ways

## 解题记录

+ 动态规划，从后向前退，$dp[i]$代表$s[0:i]$的编码种类
+ $dp[i]$可以通过$dp[i-1]$和$s[i]$转码得到，只要$s[i]!='0'$即可
+ 也可以通过$dp[i-2]$和$s[i-1:i]$转码得到，这时$'1'<=s[i-1:i]<='26'$，也就是说$s[i-1]=='1' or  s[i-1] == '2' and s[i] <= '6'$

```java
/**
 * @author: ffzs
 * @Date: 2021/4/21 上午10:11
 */
public class Solution2 {
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (cs[i] != '0') dp[i+1] = dp[i];
            if (i-1>=0 && (cs[i-1] == '1' || cs[i-1] == '2' && cs[i] <= '6')) dp[i+1] += dp[i-1];
        }
        return dp[n];
    }
}
```

![image-20210421102851304](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210421102851304.png)

+ 回溯算法求解，但是超时了，可能用来求处所有可能解法的值可以使用

```java
/**
 * @author: ffzs
 * @Date: 2021/4/21 上午9:12
 */
public class Solution {
    HashMap<String, Character> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    int n;
    StringBuilder sb = new StringBuilder();
    String s;
    public int numDecodings(String s) {
        n = s.length();
        this.s= s;
        for (int i = 0; i < 26; i++) {
            String v = String.valueOf(i+1);
            map.put(v, (char)('A' + i));
        }
        dfs(0,1);
        dfs(0,2);
        return set.size();
    }

    private void dfs (int start, int end) {
        if (end > n) {
            String code = new String(sb);
            if (!code.equals("")) set.add(code);
            return;
        }

        String cur = s.substring(start, end);

        if(!map.containsKey(cur)) return;

        sb.append(map.get(cur));
        dfs(end, end+1);
        if (end+2 <= n) dfs(end, end+2);
        sb.deleteCharAt(sb.length()-1);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0";
        System.out.println(solution.numDecodings(s));
    }
}
```

