## 231. 2 的幂

给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

 

```java
示例 1：

输入：n = 1
输出：true
解释：20 = 1
示例 2：

输入：n = 16
输出：true
解释：24 = 16
示例 3：

输入：n = 3
输出：false
示例 4：

输入：n = 4
输出：true
示例 5：

输入：n = 5
输出：false
```


提示：

-231 <= n <= 231 - 1


进阶：你能够不使用循环/递归解决此问题吗？


链接：https://leetcode-cn.com/problems/power-of-two

## 解题记录

+ 通过位运算，因为2的幂的话都是10..0的结构

```java
/**
 * @author: ffzs
 * @Date: 2021/5/30 上午8:07
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {

        while (n > 1) {
            if ((n & 1) == 1) return false;
            n >>= 1;
        }
        return n == 1;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(-1));
    }
}
```

![image-20210530082623098](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210530082623098.png)