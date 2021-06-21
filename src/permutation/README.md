## 剑指 Offer 38. 字符串的排列

## 题目

输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

```java
示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
```

```java
限制：

1 <= s 的长度 <= 8
```


链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof

## 解题记录

+ 通过回溯算法求解
+ 注意点就是多个相同字符的情况，如果之前已经有循环做过了直接跳过即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/22 上午6:57
 */
public class Solution {
    char[] sc;
    int n;
    boolean[] visited;
    List<String> lst = new ArrayList<>();
    public String[] permutation(String s) {
        sc = s.toCharArray();
        Arrays.sort(sc);
        n = sc.length;
        visited = new boolean[n];
        dfs(0, new StringBuilder());
        return lst.toArray(new String[0]);
    }

    private void dfs(int idx, StringBuilder sb) {
        if(idx == n) {
            lst.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            else if (i >= 1 && !visited[i-1] && sc[i-1] == sc[i]) continue;

            visited[i] = true;
            sb.append(sc[i]);
            dfs(idx + 1, sb);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
}
```

![image-20210622071730102](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210622071730102.png)