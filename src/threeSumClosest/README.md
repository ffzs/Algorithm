## [16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)

##  题目



给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

```java
示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
```



```java
提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
```


链接：https://leetcode-cn.com/problems/3sum-closest



## 解题记录

+ 使用枚举法求解
+ 通过控制一个数的值，剩下两个数通过双指针进行获取
+ i< left < right
+ left.v  + right.v + i.v  取到刚好大于 target为止
+ 全程比较sum和target的差值，求差值绝对值的最小值
+ 差值为0，直接返回target即可
+ 因为目的是获取target，那就在最接近target的值的范围左右取值就好，一个左一个右

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/24
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int left, right;
        int min = Integer.MAX_VALUE;
        int res = target;
        Arrays.sort(nums);
        for (int i = 0; i < len-2; ++i) {
            left = i+1;
            right = len-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    if ((sum - target) < min) {
                        min = sum - target;
                        res = sum;
                    }
                    right --;
                }
                else if (sum == target) return target;
                else {
                    if ((target - sum) < min) {
                        min = target - sum;
                        res = sum;
                    }
                    left ++;
                }
            }
        }
        return res;
    }
}
```

![image-20200624075413563](image-20200624075413563.png)