## 1588. 所有奇数长度子数组的和

## 题目

给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。

```java
示例 1：
输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
    
示例 2：
输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
    
示例 3：
输入：arr = [10,11,12]
输出：66
```

```java
提示：

1 <= arr.length <= 100
1 <= arr[i] <= 1000
```



链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays


## 解题记录

+ 如果一个数出现过n次，那么最后结果的和中就是加上`arr[i] *n 
+ 所以问题转化为一个数值究竟会出现多少回
+ 整体是奇数的话，去掉该数本身那么剩余的数个数必定是偶数，因此它的左右可以使偶偶也可以是奇奇
+ 最后通过可能出现的次数相乘得到最终出现次数，然后再加和

```java
/**
 * @author: ffzs
 * @Date: 2021/8/29 上午8:24
 */
public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - i;
            int l_even = (l + 1) / 2, r_even = (r + 1) /2;
            int l_odd = l/2, r_odd = r/2;
            res += (l_even * r_even + l_odd * r_odd) * arr[i];
        }
        return res;
    }

}
```

![image-20210829084635974](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210829084635974.png)