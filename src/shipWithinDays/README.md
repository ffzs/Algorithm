## 1011. 在 D 天内送达包裹的能力

## 题目

传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。

传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。

返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

```java
示例 1：
输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
输出：15
解释：
船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
第 1 天：1, 2, 3, 4, 5
第 2 天：6, 7
第 3 天：8
第 4 天：9
第 5 天：10
请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。 
    
示例 2：
输入：weights = [3,2,2,4,1,4], D = 3
输出：6
解释：
船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
第 1 天：3, 2
第 2 天：2, 4
第 3 天：1, 4
    
示例 3：
输入：weights = [1,2,3,1,1], D = 4
输出：3
解释：
第 1 天：1
第 2 天：2
第 3 天：3
第 4 天：1, 1
```



```java
提示：

1 <= D <= weights.length <= 50000
1 <= weights[i] <= 500
```


链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days

## 解题记录

+ 看似题目是切割问题，将数组切割成D份，求每种切割没份的和的max值，但是这种做法是比较难得，如果D确定且少的话，可以通过指针处理，但是本题不确定
+ 将题目转化一下，反过来推测，我们通过结果来反推所用天数
+ 假设结果cutline是weights种的最大的数（因为最极端的情况就是一个货物一天），到weights的和（极端情况D=1）
+ 然后通过二分法来查找这个最小值，使得通过该值分割货物得到的天数小于等于D即可

```java
/**
 * @author: ffzs
 * @Date: 2021/4/26 上午9:31
 */
public class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int left = weights[0];
        for (int i = 1; i < n; i++) {
            left = Math.max(left, weights[i]);
            weights[i] += weights[i-1];
        }
        int right = weights[n-1];

        while (left < right) {
            int mid = (left + right) >>> 1;
            int v = 0, counter = 1;
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] - v > mid) {
                    v = weights[i-1];
                    counter ++;
                }
            }
            if (counter <= D) right = mid;
            else left = mid + 1;
        }

        return left;
    }

}
```

![image-20210426101148425](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210426101148425.png)