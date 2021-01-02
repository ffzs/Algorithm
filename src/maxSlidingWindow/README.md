## [239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)

## 题目

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

```java
示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7],   k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置最大值

[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
    
示例 2：
输入：nums = [1], k = 1
输出：[1]
    
示例 3：
输入：nums = [1,-1], k = 1
输出：[1,-1]
    
示例 4：
输入：nums = [9,11], k = 2
输出：[11]
    
示例 5：
输入：nums = [4,-2], k = 2
输出：[4]
```



```java
提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
```



链接：https://leetcode-cn.com/problems/sliding-window-maximum



## 解题记录

+ 通过堆来求，最大值在最左，每回添加的时候将右边小于添加值得删掉
+ 当最左边的最大值超出了窗口的范围则删掉

```java
/**
 * @author: ffzs
 * @Date: 2021/1/2 下午2:11
 */

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;

        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i-k+1] = deque.peekFirst();
        }
        return res;
    }
}
```

![image-20210102163324504](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210102163324504.png)

+ 可以通过左右两边分别获取到范围的最大值
+ 最大值得覆盖范围限定
+ 最后再取窗口的左右两边的最大值

```java
/**
 * @author: ffzs
 * @Date: 2021/1/2 下午4:40
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n -k + 1];
        int idx = 0, max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > max || i %k == 0) max = nums[i];
            left[idx++] = max;
        }

        idx = n-1;
        max = nums[n-1];
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > max || i%k == 0) max = nums[i];
            right[idx--] = max;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i+k-1]);
        }
        return res;
    }
}
```

![image-20210102171532431](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210102171532431.png)