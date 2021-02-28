## [896. 单调数列](https://leetcode-cn.com/problems/monotonic-array/)

## 题目

如果数组是单调递增或单调递减的，那么它是单调的。

如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

当给定的数组 A 是单调数组时返回 true，否则返回 false。

 

```java
示例 1：

输入：[1,2,2,3]
输出：true
示例 2：

输入：[6,5,4,4]
输出：true
示例 3：

输入：[1,3,2]
输出：false
示例 4：

输入：[1,2,4,5]
输出：true
示例 5：

输入：[1,1,1]
输出：true
```



```java
提示：

1 <= A.length <= 50000
-100000 <= A[i] <= 100000
```


链接：https://leetcode-cn.com/problems/monotonic-array

## 解题记录

+ 循环前后相减，判断是否同时存在差值小于0且大于0的情况存在

```java
/**
 * @author: ffzs
 * @Date: 2021/2/28 上午8:19
 */
public class Solution {


    public boolean isMonotonic(int[] A) {
        int isMinus = 0, isPlus = 0;
        int n = A.length;

        if (n <= 2) return true;

        for (int i = 1; i < A.length; i++) {
            int cur = A[i] - A[i-1];
            if (cur < 0 && isMinus ==0) isMinus = 1;
            if (cur > 0 && isPlus ==0) isPlus = 1;
            if (isMinus*isPlus != 0) return false;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        int[] A = {2,2,2,1,4,5};
        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(A));
    }
}
```

![image-20210228084512202](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210228084512202.png)