## [217. 存在重复元素](https://leetcode-cn.com/problems/contains-duplicate/)

## 题目

给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

 

```java
示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
```

链接：https://leetcode-cn.com/problems/contains-duplicate



## 解题记录

+ 直接快排，然后看前后是否相同有相同的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/12/13 上午10:18
 */

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}
```

![image-20201213102641632](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201213102641632.png)

+ 也可以归并过程中判断是否相同

