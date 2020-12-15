## [738. 单调递增的数字](https://leetcode-cn.com/problems/monotone-increasing-digits/)

## 题目

给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

```java
示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
说明: N 是在 [0, 10^9] 范围内的一个整数。
```


链接：https://leetcode-cn.com/problems/monotone-increasing-digits

## 解题记录

+ 两种情况
+ 第一种：原来数字为递增，不用处理直接返回即可
+ 第二种：非递增的，找到第一个下降位子，减一，后面够改为9即可，注意下降位子相等的情况需要向前移动

```java
/**
 * @author: ffzs
 * @Date: 2020/12/15 上午7:59
 */

public class Solution {

    public int monotoneIncreasingDigits(int N) {
        boolean isIncrease = true;

        String str = String.valueOf(N);
        int[] tmp = new int[str.length()];
        int idx = -1;
        for (int i = 0; i < str.length(); i++) {
            tmp[i] = str.charAt(i) - '0';
            if (isIncrease && i>0 && tmp[i-1]>tmp[i]) {
                isIncrease = false;
                idx = i-1;
            }
        }
        if (isIncrease) return N;

        while (idx-1>=0 && tmp[idx-1] == tmp[idx]) idx--;
        tmp[idx] = tmp[idx]-1;
        for (int i = idx+1; i < tmp.length; i++) {
            tmp[i] = 9;
        }

        int res = 0;
        for (int i : tmp) {
            res = res*10 + i;
        }

        return res;
    }

}

class Test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 989998;
        System.out.println(solution.monotoneIncreasingDigits(N));
    }
}
```

![image-20201215091035206](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201215091035206.png)