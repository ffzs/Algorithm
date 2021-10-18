## 476. 数字的补数

## 题目

对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。

例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
给你一个整数 num ，输出它的补数。

 

```JAVA
示例 1：

输入：num = 5
输出：2
解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
示例 2：

输入：num = 1
输出：0
解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
```



```JAVA
提示：

1 <= num < 231
```


链接：https://leetcode-cn.com/problems/number-complement

## 解题记录

+ 优先找到num的第一个1的位置
+ 然后通过`^`处理

```java
/**
 * @author: ffzs
 * @Date: 2021/10/18 下午5:29
 */
public class Solution {

    public int findComplement(int num) {
        int idx = 1, tmp = num;
        while ((tmp >>> 1) != 0) {
            tmp = tmp >>> 1;
            idx++;
        }
        return num ^ ((1 << idx) - 1);
    }
}
```

![image-20211018174918556](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211018174918556.png)