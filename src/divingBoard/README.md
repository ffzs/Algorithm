## [面试题 16.11. 跳水板](https://leetcode-cn.com/problems/diving-board-lcci/)

## 题目

你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

```java
示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
```



```java
提示：

0 < shorter <= longer
0 <= k <= 100000
```


链接：https://leetcode-cn.com/problems/diving-board-lcci

## 解题记录

+ 只有两种板子，可能性有
+ 如果长短相同的话只有一种情况 
+ 如果不同的话，那么短木板选取有0～k个情况

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/8
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter*k};
        int[] res = new int[k+1];
        for (int i = 0; i <= k; ++i) {
            res[i] = shorter*(k-i) + longer*i;
        }
        return res;
    }
}
```

![image-20200708085518522](README.assets/image-20200708085518522.png)

## python一行解题

```python
class Solution:
    def divingBoard(self, shorter: int, longer: int, k: int) -> List[int]:
        return [] if k==0 else[shorter*k] if shorter==longer  else [shorter*(k-i)+longer*i  for i in range(k+1)]
```

![image-20200708085608533](README.assets/image-20200708085608533.png)