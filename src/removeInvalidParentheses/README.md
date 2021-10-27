## 301. 删除无效的括号

## 题目

给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

返回所有可能的结果。答案可以按 任意顺序 返回。

```java
示例 1：
输入：s = "()())()"
输出：["(())()","()()()"]
    
示例 2：
输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
    
示例 3：
输入：s = ")("
输出：[""]
```

```java
提示：

1 <= s.length <= 25
s 由小写英文字母以及括号 '(' 和 ')' 组成
s 中至多含 20 个括号
```


链接：https://leetcode-cn.com/problems/remove-invalid-parentheses

## 解题记录

+ `()())`从左到右和从右到左其实是不同的情况
+ 这里通过回溯进行暴力搜索
+ 因为可以获取到需要删掉的左括号和右括号的情况，通个这个数量进行剪枝
+ 通过set去重

```java
/**
 * @author: ffzs
 * @Date: 2021/10/27 上午7:36
 */
public class Solution {
    Set<String> set = new HashSet<>();
    char[] cs;
    int len, max;
    public List<String> removeInvalidParentheses(String s) {
        cs = s.toCharArray();
        int l = 0, r = 0, c1 = 0, c2 = 0;
        for (char c : cs) {
            if (c == '(') {l ++; c1 ++;}
            else if (c == ')') {
                if (l != 0) l--;
                else r ++;
                c2++;
            }
        }
        len = cs.length - l - r;
        max = Math.min(c1, c2);
        dfs("", 0, l, r, 0);
        return new ArrayList<>(set);
    }

    private void dfs(String sb, int idx, int l, int r, int s) {
        if (l < 0 || r < 0 || s < 0 || s > max) return;
        if (l == 0 && r == 0) {
            if (sb.length() == len) set.add(sb);
        }
        if (idx >= cs.length) return;
        char c = cs[idx];

        if (c == '(') {
            dfs(sb + c, idx+1, l, r, s+1);
            dfs(sb, idx + 1, l-1, r, s);
        }
        else if (c == ')') {
            dfs(sb + c, idx+1, l, r, s-1);
            dfs(sb, idx+1, l, r-1, s);
        }
        else {
            dfs(sb + c, idx + 1, l, r, s);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses("()())()"));
    }
}
```

![image-20211027083000205](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211027083000205.png)