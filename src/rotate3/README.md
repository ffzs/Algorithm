## [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

## 题目

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。



```java
示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
```



```java
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
```


链接：https://leetcode-cn.com/problems/rotate-array

## 解题记录

+ 通过一个数组进行缓存一部分数据
+ 然后通过将剩下的移动位置，最后将缓存填到前面

```java
/**
 * @author: ffzs
 * @Date: 2021/1/8 下午10:26
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] tmp = new int[k];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = nums[n-k+i];
        }
        for (int i = n-k-1; i >=0; --i) {
            nums[i+k] = nums[i];
        }
        System.arraycopy(tmp, 0, nums, 0, tmp.length);
    }
}
```

![image-20210108223437899](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210108223437899.png)