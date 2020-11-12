## [922. 按奇偶排序数组 II](https://leetcode-cn.com/problems/sort-array-by-parity-ii/)

## 题目

给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。 

```java
示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
```

```java
提示：

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
```


链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii

## 解题记录

+ 通过两个指针管理写入，一个是管理奇数，一个是管理偶数

```java
/**
 * @author: ffzs
 * @Date: 2020/11/12 下午3:49
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        int[] res = new int[A.length];
        for (int k : A) {
            if ((k & 1)==1) {
                res[j] = k;
                j += 2;
            }
            else{
                res[i] = k;
                i += 2;
            }
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(A)));
    }
}
```

![image-20201112190833089](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201112190833089.png)