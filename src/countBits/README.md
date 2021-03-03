## [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)

## 题目

给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

```java
示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
```

进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。


链接：https://leetcode-cn.com/problems/counting-bits

## 解题记录

+ 总结数字中1个数出现的规律，发现没到一个2的阶乘就会在原来的0-n的二进制前面加1，只要在2的阶乘后重复前面出现的情况并且加一即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/3 上午8:23
 */
public class Solution2 {

    public int[] countBits(int num) {
        int n = num + 1;
        int[] res = new int[n];

        int highBit = 0;
        for (int i = 1; i < n; i++) {
            if ((i & (i-1)) == 0) highBit = i;
            res[i] = res[i - highBit] + 1;
        }

        return res;
    }
}
```

![image-20210303084316615](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210303084316615.png)

+ 通过`x&(x−1)`获取当前数值的最低1的位置为0情况下的数值n，那么改数值的1的个数就是这个n的1的个数加一

```java
/**
 * @author: ffzs
 * @Date: 2021/3/3 上午8:03
 */
public class Solution {

    public int[] countBits(int num) {
        int n = num + 1;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            res[i] = res[(i & (i-1))] + 1;
        }
        return res;
    }

}
```

![image-20210303085344283](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210303085344283.png)