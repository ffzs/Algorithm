## [面试题 08.03. 魔术索引](https://leetcode-cn.com/problems/magic-index-lcci/)

## 题目

魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

```java
示例1:

 输入：nums = [0, 2, 3, 4, 5]
 输出：0
 说明: 0下标的元素为0
```

```java
示例2:

 输入：nums = [1, 1, 1]
 输出：1
```

```java
提示:

nums长度在[1, 1000000]之间
```


链接：https://leetcode-cn.com/problems/magic-index-lcci

## 解题记录

+ 暴力解法，直接根据题意，从小到大便利数组，第一个相同的则返回，否则返回-1

```java
/**
 * @author: ffzs
 * @Date: 2020/7/31 上午8:45
 */
public class Solution {
    public int findMagicIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}

```

![image-20200731085630102](README.assets/image-20200731085630102.png)

+ 二分剪枝
+ 虽说数组是递增的，但是由于数组的值可以是相同的，感觉这个相同的值可以随时出现
+ 不过这个题感觉是用了二分查找，但是无非是将递推转化为了递归而已，比对的顺序其实没有变
+ 结构上更像是二叉树查找

```java
/**
 * @author: ffzs
 * @Date: 2020/7/31 上午8:56
 */
public class Solution2 {

    public int findMagicIndex(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    private int dfs (int[] nums, int l, int r) {
        if (l > r) return -1;

        int mid = l + r >>> 1;

        int left = dfs(nums, l, mid-1);

        if (left != -1) return left;
        else if (nums[mid] == mid) return mid;

        return dfs(nums, mid+1, r);
    }
}

```

![image-20200731091258017](README.assets/image-20200731091258017.png)