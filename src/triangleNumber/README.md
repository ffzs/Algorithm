## 611. 有效三角形的个数

## 题目

给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

```java
示例 1:

输入: [2,2,3,4]
输出: 3
解释:
有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
```



```java
注意:

数组长度不超过1000。
数组里整数的范围为 [0, 1000]。
```


链接：https://leetcode-cn.com/problems/valid-triangle-number

## 解题记录

+ 通过双指针求解
+ 三条线段能否组成三角形的一个特征是，两条短的线段相加小于第三边
+ 优先确定前两条边，然后找第三条边的临界位置累加

```java
/**
 * @author: ffzs
 * @Date: 2021/8/4 上午6:53
 */
public class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 1;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) k++;
                res += Math.max(k - j, 0);
            }
        }
        return res;
    }
}
```

![image-20210804071310129](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210804071310129.png)