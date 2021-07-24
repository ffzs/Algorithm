## 1743. 从相邻元素对还原数组

## 题目

存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。

给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。

题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。

返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。

```java
示例 1：

输入：adjacentPairs = [[2,1],[3,4],[3,2]]
输出：[1,2,3,4]
解释：数组的所有相邻元素对都在 adjacentPairs 中。
特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
示例 2：

输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
输出：[-2,4,1,-3]
解释：数组中可能存在负数。
另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
示例 3：

输入：adjacentPairs = [[100000,-100000]]
输出：[100000,-100000]
```

```java
提示：

nums.length == n
adjacentPairs.length == n - 1
adjacentPairs[i].length == 2
2 <= n <= 105
-105 <= nums[i], ui, vi <= 105
题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
```


链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs

## 解题记录

+ 通过map记录邻接关系，因为顺序不一定，那么记录的时候要通过list记录
+ 由于一定是能够组成数组，那么数据长度为邻接关系的 n + 1
+ 而且每一个数值对应关系最多为2,最少为1（起止）

```java
/**
 * @author: ffzs
 * @Date: 2021/7/25 上午6:46
 */
public class Solution {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        if (n == 1) return adjacentPairs[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int a = adjacentPair[0], b = adjacentPair[1];
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> it : map.entrySet()) {
            if (it.getValue().size() == 1) {
                start = it.getKey();
                break;
            }
        }


        int[] res = new int[n+1];
        res[0] = start;
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < res.length; i++) {
            List<Integer> l = map.get(res[i-1]);
            res[i] = l.get(0) == res[i-2] ? l.get(1) : l.get(0);
        }
        return res;
    }

}
```

![image-20210725075558392](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210725075558392.png)