## [290. 单词规律](https://leetcode-cn.com/problems/word-pattern/)

## 题目

给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

```java
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
    
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
    
示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
    
示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
```

说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    

链接：https://leetcode-cn.com/problems/word-pattern

## 解题记录

+ 通过映射处理，pattern中的每一个字符对应一种字符串，如果有一对多的情况的话那么直接为false
+ 有一种情况就是pattern中的多个字符对应同一种字符，这样需要在记录的时候检查是否为重复即可

```java
/**
 * @author: ffzs
 * @Date: 2020/12/16 上午7:58
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) return false;
        String[] tmp = new String[26];
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i)-'a';
            if (tmp[idx]==null) {
                for (String str : tmp) {
                    if (str!=null && str.equals(strs[i])) return false;
                }
                tmp[idx] = strs[i];
            }
            else {
                if (!strs[i].equals(tmp[idx])) return false;
            }
        }
        return true;
    }
}
```

![image-20201216081258776](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201216081258776.png)