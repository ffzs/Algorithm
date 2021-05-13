## 1310. 子数组异或查询

## 题目

有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

并返回一个包含给定查询 queries 所有结果的数组。

 

```java
示例 1：

输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8] 
解释：
数组中元素的二进制表示形式是：
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
示例 2：

输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
输出：[8,0,4,4]
```



```java
提示：

1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 10^9
1 <= queries.length <= 3 * 10^4
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] < arr.length
```


链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray

## 解题记录

+ 由于异或的奇特运算方式 a ^ b = c,  c ^ a = b; 可以通过类似前缀和的方法进行处理
+ `[0,1] ^ [1,3] = [0,3]` 因此 `[0,3]^ [0,1] = [1,3]` 我们可以求所有`[0, 1..n]`的值，然后通过这种方法获取区域的值

```java
/**
 * @author: ffzs
 * @Date: 2021/5/13 下午5:24
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] tmp = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i+1] = tmp[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp[queries[i][0]] ^ tmp[queries[i][1] + 1];
        }
        return res;
    }

}
```

![image-20210513183300127](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210513183300127.png)