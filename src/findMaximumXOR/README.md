## 421. 数组中两个数的最大异或值

## 题目

给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。

进阶：你可以在 O(n) 的时间解决这个问题吗？

 

```java
示例 1：

输入：nums = [3,10,5,25,2,8]
输出：28
解释：最大运算结果是 5 XOR 25 = 28.
示例 2：

输入：nums = [0]
输出：0
示例 3：

输入：nums = [2,4]
输出：6
示例 4：

输入：nums = [8,10,2]
输出：10
示例 5：

输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
输出：127
```

```java
提示：

1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1
```


链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array

## 解题记录

+ 暴力解法，直接遍历i，j然后通过异或求解即可

```java
/**
 * @author: ffzs
 * @Date: 2021/5/16 上午8:21
 */
public class Solution {

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, nums[i]^nums[j]);
            }
        }

        return res;
    }

}
```

![image-20210516092445051](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210516092445051.png)

+ 通过将每一个值转化为二进制表示方法，要求最大值的话，可能是越高位的值为1的话值越大，那没通过从左向右依次获取二进制位的值，然后再通过异或处理，看看有没有能够满足要求的两个值，有的话说明该位可以是1，将该位更改为1后，再查找下一位

```java
/**
 * @author: ffzs
 * @Date: 2021/5/16 上午9:02
 */
public class Solution2 {

    public int findMaximumXOR(int[] nums) {
        int maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int n = 32;
        while (n > 0 && maxValue >> n != 1) n--;
        n++;
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res <<= 1;
            int cur = res | 1;
            set.clear();
            for (int num : nums) {
                set.add(num>>i);
                if (set.contains(num>>i ^ cur)){
                    res |= 1;
                    break;
                }
            }
        }
        return res;
    }
}


class Test {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] nums = {3, 10, 5, 25, 2, 8};
        int[] nums = {0};
        System.out.println(s.findMaximumXOR(nums));
    }
}
```

![image-20210516093126678](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210516093126678.png)