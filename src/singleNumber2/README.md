## 260. 只出现一次的数字 III

## 题目

给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

 

进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

 

示例 1：

输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。
示例 2：

输入：nums = [-1,0]
输出：[-1,0]
示例 3：

输入：nums = [0,1]
输出：[1,0]
提示：

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
除两个只出现一次的整数外，nums 中的其他数字都出现两次


链接：https://leetcode-cn.com/problems/single-number-iii

## 解题记录

+ 通过异或求解
+ 只有两个数值为单个情况，其他的都为2个的话，说明通过所有值取异或相同的会被抵消掉，剩下的为那两个单个值得异或
+ 这里找到两值得异或情况的第一个1,这个1说明这两个数在这一位上是不同的
+ 因此通过这位为1或是0进行分组
+ 然后再异或分别求出这两个值即可

```java
/**
 * @author: ffzs
 * @Date: 2021/10/30 上午7:25
 */
public class Solution2 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        xor = (xor ^ (xor -1)) & xor;

        int[] res = new int[2];

        for (int num : nums) {
            if ((num & xor) == 0) res[0] ^= num;
            else res[1] ^= num;
        }

        return res;
    }

}
```

![image-20211030073958860](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211030073958860.png)