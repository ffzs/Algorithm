## 645. 错误的集合

## 题目

集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。

给定一个数组 nums 代表了集合 S 发生错误后的结果。

请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

```java
示例 1：

输入：nums = [1,2,2,4]
输出：[2,3]
示例 2：

输入：nums = [1,1]
输出：[1,2]
```

```java
提示：

2 <= nums.length <= 104
1 <= nums[i] <= 104
```


链接：https://leetcode-cn.com/problems/set-mismatch

## 解题记录

+ 直接通过计数即可，找到计数为2和计数为0的数值

```java
/**
 * @author: ffzs
 * @Date: 2021/7/4 上午10:05
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length];
        for (int num : nums) {
            counter[num - 1]++;
        }
        int[] res = new int[2];
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 2) res[0] = i + 1;
            if (counter[i] == 0) res[1] = i + 1;
        }
        return res;
    }

}
```

![image-20210704102254575](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210704102254575.png)