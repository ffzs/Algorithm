## [77. 组合](https://leetcode-cn.com/problems/combinations/)

## 题目

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

```java
示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```


链接：https://leetcode-cn.com/problems/combinations

## 解题记录

+ 通过回溯算法进行计算
+ 该题因为数值不会重复，每回循环的范围需要控制一下：如k==2，就不会出现[4,3]的情况，这里循环就没有必要带上4
+ 还有就是其实位置要比list的最后一位大

```java
/**
 * @author: ffzs
 * @Date: 2020/9/8 上午7:04
 */

public class Solution {
    int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;

        dfs(k, new ArrayList<>());
        return res;
    }
    
    private void dfs (int k, List<Integer> list) {
        if (k==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        int start = list.isEmpty()? 1: list.get(list.size()-1)+1;
        for (int i = start; i <= n-k+1; i++) {
            list.add(i);
            dfs(k-1, list);
            list.remove(list.size()-1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4,2));
    }
}
```

![image-20200908072445931](README.assets/image-20200908072445931.png)