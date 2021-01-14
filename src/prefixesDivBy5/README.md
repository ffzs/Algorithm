## [1018. 可被 5 整除的二进制前缀](https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/)

## 题目

给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。

```java
示例 1：
输入：[0,1,1]
输出：[true,false,false]
解释：
输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
    
示例 2：
输入：[1,1,1]
输出：[false,false,false]
    
示例 3：
输入：[0,1,1,1,1,1]
输出：[true,false,false,false,true,false]
    
示例 4：
输入：[1,1,1,0,1]
输出：[false,false,false,false,false]
```



```java
提示：

1 <= A.length <= 30000
A[i] 为 0 或 1
```


链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5

## 解题记录

+ 直接通过位运算即可，能否被5整除只需要看最后一位即可，不用保存整个数，只要最后一位数就行

```java
/**
 * @author: ffzs
 * @Date: 2021/1/14 下午8:24
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        long cur = 0;
        List<Boolean> res = new ArrayList<>(A.length);

        for (int value : A) {
            cur = ((cur << 1) + value) % 5;
            res.add(cur == 0);
        }
        return res;
    }
}
```

![image-20210114202849675](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210114202849675.png)