## [1047. 删除字符串中的所有相邻重复项](https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/)

## 题目

给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 

```java
示例：

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
```



```java
提示：

1 <= S.length <= 20000
S 仅由小写英文字母组成。
```



链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string



## 解题记录

+ 通过递归的方式减少字符串中成对出现的情况，最后数据字符串即可



```java
/**
 * @author: ffzs
 * @Date: 2021/3/9 上午7:53
 */
public class Solution {

    public String removeDuplicates(String S) {
        char[] cs = S.toCharArray();
        int n = cs.length;
        boolean[] tmp = new boolean[n];
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i-1] && !tmp[i] && !tmp[i-1]) {
                int l = i-1, r = i;
                while (l>=0 && r < n && cs[l] == cs[r] && !tmp[l] && !tmp[r]) {
                    tmp[l--] = true;
                    tmp[r++] = true;
                    flag = true;
                }
            }
        }

        if (!flag) return S;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!tmp[i]) sb.append(cs[i]);
        }

        return removeDuplicates(sb.toString());
    }

}
```

![image-20210309083916526](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210309083916526.png)