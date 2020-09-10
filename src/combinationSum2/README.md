## [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

## 题目

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

```java
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

```java
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
```

链接：https://leetcode-cn.com/problems/combination-sum-ii


## 解题记录

+ 和昨天的题处理逻辑基本相同，使用回溯[Leetcode: NO.39 组合总和 回溯算法](https://blog.csdn.net/tonydz0523/article/details/108481216)
+ 这里的这个题目每个元素只能使用一次，设置start
+ 不能重复，排序之后，通过set进行统计

```java
/**
 * @author: ffzs
 * @Date: 2020/9/10 上午7:08
 */
public class Solution {
    Set<List<Integer>> res = new HashSet<>();
    int[] candidates;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        dfs(target, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void dfs (int target, int start, List<Integer> list) {
        if (target == 0) {
            List<Integer> ret = new ArrayList<>(list);
            Collections.sort(ret);
            res.add(new ArrayList<>(ret));
        }
        else if (target > 0) {
            for (int i = start; i < n; i++) {
                if (target >= candidates[i]) {
                    list.add(candidates[i]);
                    dfs(target-candidates[i], i+1, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
```

![image-20200910071625298](README.assets/image-20200910071625298.png)

+ 也可以先进行排序处理
+ 排序的要处理好重复的逻辑，每一层不要加入同样的元素，如果有相同的只能添加第一个，因为start要传递下去

```java
/**
 * @author: ffzs
 * @Date: 2020/9/10 上午7:16
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int [] candidates;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        this.n = candidates.length;
        dfs(target, 0, new ArrayList<>());
        return res;
    }

    private void dfs (int target, int start, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            if (target >= candidates[i] && (i == start || candidates[i] != candidates[i-1])) {
                list.add(candidates[i]);
                dfs(target-candidates[i], i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
```



![image-20200910073020800](README.assets/image-20200910073020800.png)

