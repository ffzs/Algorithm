## [456. 132模式](https://leetcode-cn.com/problems/132-pattern/)

## 题目

给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。

如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。

进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？

 

```java
示例 1：
输入：nums = [1,2,3,4]
输出：false
解释：序列中不存在 132 模式的子序列。
    
示例 2：
输入：nums = [3,1,4,2]
输出：true
解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
    
示例 3：
输入：nums = [-1,3,2,0]
输出：true
解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
```



```java
提示：

n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109
```


链接：https://leetcode-cn.com/problems/132-pattern

## 解题记录

+ 我们优先求的左边的最小值，然后通过判断右边有没有处于该值和左边最小之间的值即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/24 下午3:39
 */
public class Solution {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
        }

        for (int i = n - 1; i > 0; i--) {
            if (left[i] < nums[i] - 1 && check(nums, i, nums[i], left[i])) return true;
        }
        return false;
    }

    private boolean check (int[] nums, int i, int max, int min) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > min && nums[j] < max) return true;
        }
        return false;
    }

}
```

![image-20210324165218746](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210324165218746.png)

## 进阶

+ 通过单调栈来维护右边的相对大值

```java
/**
 * @author: ffzs
 * @Date: 2021/3/24 下午4:35
 */
public class Solution2 {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i-1], nums[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n-1; i > 0; i--) {
            if (nums[i] > left[i] + 1) {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    max = stack.pop();
                }
                if (left[i] < max) return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
```

![image-20210324170552786](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210324170552786.png)