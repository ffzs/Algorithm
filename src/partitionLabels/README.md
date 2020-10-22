## [763. 划分字母区间](https://leetcode-cn.com/problems/partition-labels/)

## 题目

字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 

```java
示例 1：

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
```

```java
提示：

S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
```


链接：https://leetcode-cn.com/problems/partition-labels

## 解题记录

+ 本题的解法要首先获取获取每个字符的最后一个字符的位置
+ 然后获取第一个字符，看它与它最后那个字符中间的那些字符的最后字符刷新最后字符，遍历这个区间全部字符后，如果不在更新最后位置，那么返回这段距离

```java
/**
 * @author: ffzs
 * @Date: 2020/10/22 上午8:15
 */

public class Solution {
    int[] tmp;
    List<Integer> res = new ArrayList<>();
    public List<Integer> partitionLabels(String S) {
        char[] seq = S.toCharArray();
        tmp = new int[26];
        Arrays.fill(tmp, -1);

        for (int i = 0; i < seq.length; i++) {
            tmp[seq[i]-'a'] = i;
        }

        int index = 0;
        while (index < seq.length) {
            int ret = partitionLabels(seq, index);
            res.add(ret+1);
            index += ret+1;
        }
        return res;
    }
    private int partitionLabels(char[] seq, int i) {

        int max = 0, j = i;
        do {
            max = Math.max(tmp[seq[j++] -'a'], max);
        } while (j < max);
        return max-i;
    }
}

class Test{
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(S));
    }
}
```

![image-20201022090935858](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201022090935858.png)