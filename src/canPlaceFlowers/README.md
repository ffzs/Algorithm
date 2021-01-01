## [605. 种花问题](https://leetcode-cn.com/problems/can-place-flowers/)

## 题目

假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
注意:

数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。


链接：https://leetcode-cn.com/problems/can-place-flowers

## 解题记录

+ 通过遍历数组，检查周围的是否有已经种了花，种了的话n-1
+ n小于等于0返回true
+ 否则返回false

```java

/**
 * @author: ffzs
 * @Date: 2021/1/1 上午8:18
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) i += 2;
            else {
                if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) {
                    n--;
                    i += 2;
                }
                else i += 3;
            }
            if (n <= 0) return true;
        }
        return false;
    }
}
```

![image-20210101085312146](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210101085312146.png)