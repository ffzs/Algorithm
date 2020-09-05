## [60. 第k个排列](https://leetcode-cn.com/problems/permutation-sequence/)

## 题目

给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

```java
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
```

```java
示例 1:

输入: n = 3, k = 3
输出: "213"
```

```java
示例 2:

输入: n = 4, k = 9
输出: "2314"
```

链接：https://leetcode-cn.com/problems/permutation-sequence

## 解题记录

+ 其实是一道数学题
+ 由于是从上到下进行排序，那么就通过给的k进行判断其区域
+ n==3时，一共`3*2*1`种情况，第一个数字每种情况`3*2*1/3=2*1`,那么k/2的商就是第几个数
+ k==3时，`3/2=1..1`那么第一个数，因为0是第一个，1就是第二个，就是2
+ 还有一个问题就是这里给的k是第几个，而不是index需要k-1来表示第几个数



```java
/**
 * @author: ffzs
 * @Date: 2020/9/5 上午8:39
 */
public class Solution {

    public String getPermutation(int n, int k) {
        if (n==1) return "1";
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tmp.add(i);
        }
        int total = factorial(n - 1);
        int index, remain=k-1;
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i > 1; --i) {
            index = remain/total;
            remain = remain%total;
            total = total/i;
            res.append(tmp.remove(index));
        }
        res.append(tmp.remove(remain));
        res.append(tmp.get(0));
        return res.toString();
    }

    private int factorial(int n) {
        if (n < 1) return -1;
        else if (n == 1) return 1;
        else return factorial(n - 1) * n;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3,3));
    }
}
```

![image-20200905093056799](README.assets/image-20200905093056799.png)