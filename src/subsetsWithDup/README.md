## [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)

## 题目

给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 

```java
示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
```

```java
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
```


链接：https://leetcode-cn.com/problems/subsets-ii

## 解题记录

+ 1,2,2;中22是相同的值，x2和2x只有一个存在即可，这里选着跳过x2的情况
+ 也就是说只要前面的没有选且这个数和前面的那个数相同，那么这条选着线是重复的直接跳出



```java
/**
 * @author: ffzs
 * @Date: 2021/3/31 上午9:53
 */
public class Solution {

    List<List<Integer>> res;
    List<Integer> list;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        list = new ArrayList<>();
        this.nums = nums;

        dfs(-1,0);
        return res;
    }

    private void dfs(int pre, int idx) {
        if (idx >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(pre, idx + 1);
        if (pre + 1 != idx && idx != 0 && nums[idx-1]==nums[idx]) return;
        list.add(nums[idx]);
        dfs(idx, idx + 1);
        list.remove(list.size() - 1);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,2,2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}
```

![image-20210331120611346](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210331120611346.png)

