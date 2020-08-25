## [491. 递增子序列](https://leetcode-cn.com/problems/increasing-subsequences/)

## 题目

给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

```java
示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
```

```java
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
```


链接：https://leetcode-cn.com/problems/increasing-subsequences

## 解题记录

+ 遍历数组，进行子序列的积累，到index位i的一位，将i前所有小于i的情况作为2元数组
+ 遍历res中所有数组，如果数组最后一个小于等于`nums[i]`,那么和`nums[i]`组成新的数组并存入res中
+ 由于可能出现重复的情况，我们设置res为hashset，最后换成list

```java
/**
 * @author: ffzs
 * @Date: 2020/8/25 上午8:33
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length <= 1) return new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 1; i < nums.length; ++i) {
            Set<List<Integer>> resTmp = new HashSet<>(res);
            for (List<Integer> re : resTmp) {
                if (nums[i] >= re.get(re.size()-1)) {
                    List<Integer> tmp = new ArrayList<>(re);
                    tmp.add(nums[i]);
                    res.add(tmp);
                }
            }
            if(nums[i] != nums[i-1]){
                for (int j = 0; j < i; j++) {
                    if (nums[j] <= nums[i]) {
                        res.add(List.of(nums[j], nums[i]));
                    }
                }
            }
            else res.add(List.of(nums[i], nums[i]));
        }
        return new ArrayList<>(res);
    }
}
```

![image-20200825091814660](README.assets/image-20200825091814660.png)

+ 上面的算法没有避免一些重复情况的出现以及set的去重
+ 使用回溯的方法能更好的解决这一问题
+ 在循环的过程中对于每一个符合条件的数，我们都有加到list中和不加两种情况作为选择

```java
/**
 * @author: ffzs
 * @Date: 2020/8/25 上午9:34
 */
public class Solution2 {
    int[] nums;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>(), Integer.MIN_VALUE);
        return res;
    }
    private void dfs (int i, List<Integer> list, int last) {
        if (i == nums.length) {
            if (list.size() >= 2) res.add(new ArrayList<>(list));
        }
        else {
            // 符合要求添加变量
            if (nums[i] >= last){
                list.add(nums[i]);
                dfs(i+1, list, nums[i]);
                list.remove(list.size()-1);  // list 回溯
            }
            // 未添加变量，避免重复跳过连续相等情况
            if (nums[i] != last) {
                dfs(i+1, list, last);
            }
        }
    }
}
```

![image-20200825094510598](README.assets/image-20200825094510598.png)