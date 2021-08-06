## 457. 环形数组是否存在循环

## 题目

存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：

如果 nums[i] 是正数，向前 移动 nums[i] 步
如果 nums[i] 是负数，向后 移动 nums[i] 步
因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。

数组中的 循环 由长度为 k 的下标序列 seq ：

遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
所有 nums[seq[j]] 应当不是 全正 就是 全负
k > 1
如果 nums 中存在循环，返回 true ；否则，返回 false 。

```java
示例 1：

输入：nums = [2,-1,1,2,2]
输出：true
解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
示例 2：

输入：nums = [-1,2]
输出：false
解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
示例 3:

输入：nums = [-2,1,-1,-2,-2]
输出：false
解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
所有 nums[seq[j]] 应当不是全正就是全负。
```

```java
提示：

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0

进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
```


链接：https://leetcode-cn.com/problems/circular-array-loop

## 解题记录

+ 通过快慢指针判断是否有环状结构即可
+ 因为如果方向不一致的话就没有办法使用快慢指针进行判断，因此还要判断方向是否一致
+ 然后通过在数组中标0的方法去掉已经访问过的点

```java
/**
 * @author: ffzs
 * @Date: 2021/8/7 上午6:48
 */
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int s = i, f = next(nums, i);
            while (nums[s] * nums[f] > 0 && nums[s] * nums[next(nums, f)] > 0) {
                if (s == f) {
                    if (s != next(nums, s)) return true;
                    else break;
                }
                s = next(nums, s);
                f = next(nums, next(nums, f));
            }
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                int t = add;
                add = next(nums, add);
                nums[t] = 0;
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        // 有可能为负
        return ((i + nums[i]) % n + n) % n;
    }

}
```

![image-20210807072647066](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210807072647066.png)