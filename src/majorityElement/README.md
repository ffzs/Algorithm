## 面试题 17.10. 主要元素

## 题目

数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。

 

```java
示例 1：

输入：[1,2,5,9,5,9,5,5,5]
输出：5
示例 2：

输入：[3,2]
输出：-1
示例 3：

输入：[2,2,1,1,1,2,2]
输出：2
```


链接：https://leetcode-cn.com/problems/find-majority-element-lcci

## 解题记录

+ 因为一个数个数超过一半的话，那么他的个数一定是超过其他数值的个数和
+ 这里维护一个个数比较突出的数值，计算该数组中该数值的个数，如果超过数组长度的一半则返回

```java
/**
 * @author: ffzs
 * @Date: 2021/7/9 上午7:02
 */
public class Solution {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int aim = nums.length/2;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) count++;
            else count = 1;
            if (count>aim) return nums[i];
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int pre = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                count ++;
                pre = num;
            }
            else if (pre == num) count++;
            else count --;
        }

        if (count>0) {
            int c = 0;
            for (int num : nums) {
                if (num == pre) c++;
            }

            if (c > nums.length /2) return pre;
        }
        return -1;
    }

}
```

![image-20210709071903378](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210709071903378.png)