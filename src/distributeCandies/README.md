## 575. 分糖果

## 题目

给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

```java
示例 1:

输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
示例 2 :

输入: candies = [1,1,2,3]
输出: 2
解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
注意:

数组的长度为[2, 10,000]，并且确定为偶数。
数组中数字的大小在范围[-100,000, 100,000]内。
```


链接：https://leetcode-cn.com/problems/distribute-candies

## 解题记录

+ 因为是评分所有获得的，获取最多种类糖果的方式为每一个糖都是独立的种类
+ 因此弟弟妹妹获取最多糖种类的情况也不可能超过总糖果数的一半
+ 这里主要统计出一共有多少中糖果种类，尽可能的分给妹妹多的种类

```java
/**
 * @author: ffzs
 * @Date: 2021/11/1 上午7:26
 */
public class Solution {

    public int distributeCandies(int[] candyType) {
        boolean[] tmp = new boolean[200001];
        int cnt = 0;
        for (int i : candyType) {
            int cur = i+100000;
            if (!tmp[cur]) {
                cnt++;
                tmp[cur] = true;
            }
            else tmp[i+100000] = true;
        }
        return Math.min(cnt, candyType.length / 2);
    }

}
```

![image-20211101073827231](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211101073827231.png)