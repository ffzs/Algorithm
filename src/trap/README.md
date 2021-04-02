## 面试题 17.21. 直方图的水量

## 题目

给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。

```java
示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
```


链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci

## 解题记录

+ 找波谷的问题，然后计算波谷的中的蓄水能力
+ 通过双指针左右向中间靠拢， 同时记录当前的左侧最大和右侧最大值，因为两侧最大的情况下矮的以便是短板，决定蓄水能力
+ 移动的过程中遵循矮的一边移动，并更新蓄水多少



```java
/**
 * @author: ffzs
 * @Date: 2021/4/2 上午8:52
 */
public class Solution {

    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int lm = 0, rm = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (lm > height[l]) res += lm - height[l];
                else lm = height[l];
                l++;
            }
            else {
                if (rm > height[r]) res += rm - height[r];
                else rm = height[r];
                r--;
            }
        }
        return res;
    }

}
```

![image-20210402093338937](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210402093338937.png)