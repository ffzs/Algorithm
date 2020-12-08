## [842. 将数组拆分成斐波那契序列](https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/)

## 题目

给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

形式上，斐波那契式序列是一个非负整数列表 F，且满足：

0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 

```java
示例 1：

输入："123456579"
输出：[123,456,579]
示例 2：

输入: "11235813"
输出: [1,1,2,3,5,8,13]
示例 3：

输入: "112358130"
输出: []
解释: 这项任务无法完成。
示例 4：

输入："0123"
输出：[]
解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
示例 5：

输入: "1101111"
输出: [110, 1, 111]
解释: 输出 [11,0,11,11] 也同样被接受。
```


提示：

1 <= S.length <= 200
字符串 S 中只含有数字。


链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence

## 解题记录

+ 通过回溯算法计算，每次获取一段字符转化为数字
+ 注意数字的不能大于Integer.MAX_VALUE
+ 两位数字开头不能为0等情况

```java
/**
 * @author: ffzs
 * @Date: 2020/12/8 下午7:46
 */
public class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S.toCharArray(), res, 0);
        return res;
    }

    private boolean dfs(char[] cs, List<Integer> list, int index) {
        if (index == cs.length) return list.size() >= 3;

        long curL = 0L;
        for (int i = index; i < cs.length; i++) {
            if (i > index && cs[index] == '0') break;
            curL = curL * 10 + cs[i] - '0';
            if (curL > Integer.MAX_VALUE) break;
            int cur = (int)curL, size = list.size();
            if (size >= 2) {
                int sum = list.get(size-1) + list.get(size-2);
                if (cur < sum) continue;
                else if (cur > sum) break;
            }
            list.add(cur);
            if (dfs(cs, list, i+1)) return true;
            else list.remove(list.size()-1);
        }
        return false;
    }
}
```

![image-20201208204032867](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201208204032867.png)