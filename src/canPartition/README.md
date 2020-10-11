## [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)

## 题目

给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200

```java
示例 1:

输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
```

```java
示例 2:

输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
```


链接：https://leetcode-cn.com/problems/partition-equal-subset-sum

## 解题记录

+ 使用深度有限算法
+ 将问题转化为能否通过家和得到总和一半的问题
+ 通过一个数组记录访问情况，如果是访问过的sum与index的组合标记一下 ，该组合无法成功

```java
boolean[] tmp;
public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num;
    if ((sum&1)==1) return false;
    sum /= 2;
    tmp = new boolean[sum*100+nums.length];
    return dfs(0, sum, nums);
}

private boolean dfs (int idx, int sum, int[] nums) {
    if (sum == 0) return true;
    if (sum < 0 || idx > nums.length-1) return false;
    if (tmp[sum*100+idx]) return false;
    if (dfs(idx+1, sum-nums[idx], nums) || dfs(idx+1, sum, nums)) return true;
    else {
        tmp[sum*100+idx] = true;
        return false;
    }
}
```

![image-20201011112617082](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201011112617082.png)