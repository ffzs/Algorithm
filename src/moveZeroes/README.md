## [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

## 题目

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。


链接：https://leetcode-cn.com/problems/move-zeroes

## 解题记录

+ 遍历数组，将不是0的数按照顺序写入数组
+ 将剩余的位置都填上0；

```java
/**
 * @author: ffzs
 * @Date: 2020/11/19 下午6:29
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i<nums.length) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
            i++;
        }
        while (j<nums.length) {
            nums[j++] = 0;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

![image-20201119191058242](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201119191058242.png)