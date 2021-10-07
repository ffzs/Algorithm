## 187. 重复的DNA序列

## 题目

所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

 

```java
示例 1：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]
```



```java
提示：

0 <= s.length <= 105
s[i] 为 'A'、'C'、'G' 或 'T'
```


链接：https://leetcode-cn.com/problems/repeated-dna-sequences

## 解题记录

+ 状态压缩，首先ATGC可以理解为4进制，就是通过0,1,2,3代表ATGC四个字符
+ 长度为10的字符串转化为二进制的话长度是20
+ 通过`(( 1 << (len * 2)) - 1)`来维持这个长度为20的窗口
+ 然后就是通过set记录是否曾经出现过，统计出现过的字符串情况

```java
/**
 * @author: ffzs
 * @Date: 2021/10/8 上午6:40
 */
public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        final int len = 10;
        int[] bin = new int[128];
        bin['A'] = 0;
        bin['T'] = 1;
        bin['G'] = 2;
        bin['C'] = 3;
        char[] cs = s.toCharArray();
        int n = cs.length;
        
        int tmp = 0;

        Set<String> set = new HashSet<>();
        Set<Integer> cnt = new HashSet<>();

        for (int i = 0; i <= (n - len); i++) {
            if (i == 0) {
                for (int j = 0; j < len; j++) {
                    tmp = (tmp << 2) | bin[cs[j]];
                }
            }
            else tmp = ((tmp << 2) | bin[cs[i + len - 1]]) & (( 1 << (len * 2)) - 1);
            if (cnt.contains(tmp)) set.add(s.substring(i, i + len));
            cnt.add(tmp);
        }
        return new ArrayList<>(set);
    }

}
```

![image-20211008072023703](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211008072023703.png)