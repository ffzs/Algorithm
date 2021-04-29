## 403. 青蛙过河

## 题目

一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。

给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。

开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。

如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

```java
示例 1：
输入：stones = [0,1,3,5,6,8,12,17]
输出：true
解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。

示例 2：
输入：stones = [0,1,2,3,4,8,9,11]
输出：false
解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
```

```java
提示：

2 <= stones.length <= 2000
0 <= stones[i] <= 231 - 1
stones[0] == 0
```


链接：https://leetcode-cn.com/problems/frog-jump


## 解题记录

+ 通过深度优先算法对可能情况进行查找
+ 因为在查找的时候可能重复查找，为了避免重复查找，我们需要根据当前的值和对应的k做去重
+ 应为k的范围是不大于2000, 我们可以通过index*1000 + k的方式处理key
+ 通过一个set记录key即可，出现过还没有返回true说明一定是false

```java
/**
 * @author: ffzs
 * @Date: 2021/4/29 下午3:35
 */
public class Solution {
    Set<Integer> mark;
    Map<Integer, Integer> map;
    int[] stones;
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        this.stones = stones;
        map = new HashMap<>();
        mark = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        return dfs(1, 1);
    }

    private boolean dfs (int index, int k) {
        if (index == stones.length - 1) return true;
        else if (index >= stones.length) return false;

        int cur = stones[index];
        int label = index * 1000 + k;
        if (mark.contains(label)) return false;
        else mark.add(label);

        for (int i = cur + k - 1; i <= cur + k + 1; i++) {
            if (map.containsKey(i) && i > cur && dfs (map.get(i), i - cur)) return true;
        }
        return false;
    }

}
```

![image-20210429193756559](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210429193756559.png)