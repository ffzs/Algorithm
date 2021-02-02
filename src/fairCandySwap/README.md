## [888. 公平的糖果棒交换](https://leetcode-cn.com/problems/fair-candy-swap/)

## 题目

爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。

因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

如果有多个答案，你可以返回其中任何一个。保证答案存在。 

```java
示例 1：

输入：A = [1,1], B = [2,2]
输出：[1,2]
示例 2：

输入：A = [1,2], B = [2,3]
输出：[1,2]
示例 3：

输入：A = [2], B = [1,3]
输出：[2,3]
示例 4：

输入：A = [1,2,5], B = [2,4]
输出：[5,4
```



```java
提示：

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
保证爱丽丝与鲍勃的糖果总量不同。
答案肯定存在。
```


链接：https://leetcode-cn.com/problems/fair-candy-swap

## 解题记录

+ 通过一个set对A中出现数字缓存
+ 通过计算A，B只差找到需要交换的两值得差值
+ 遍历B检查是否有该值



```java
/**
 * @author: ffzs
 * @Date: 2021/2/2 上午9:10
 */
public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        boolean[] set = new boolean[100001];
        for (int i : A) {
            sa += i;
            set[i] = true;
        }

        for (int i : B) {
            sb += i;
        }

        int gap = (sa - sb) /2;
        for (int i : B) {
            int need = i + gap;
            if (need >=0 && need <= 100000 && set[need]) return new int[]{need, i};
        }

        return new int[2];
    }

}
```

![image-20210202095133658](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210202095133658.png)