## [977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)

## 题目

给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

```java
示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
```

```java
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]
```

```java
提示：

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A 已按非递减顺序排序。
```


链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array

## 解题记录

+ 计数排序

```java
/**
 * @author: ffzs
 * @Date: 2020/10/16 上午7:36
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int max = Math.max(-A[0], A[A.length-1]);
        int[] tmp = new int[max+1];

        for (int i : A) {
            if (i<0) tmp[-i]++;
            else tmp[i]++;
        }

        int[] res = new int[A.length];
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0){
                for (int j = 0; j < tmp[i]; j++) {
                    res[index++] = i*i;
                }
            }
        }
        return res;
    }
}
```

![image-20201016074837620](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201016074837620.png)

+ 从两端进行比较比较，将平方较大的以此写入数组

```java
/**
 * @author: ffzs
 * @Date: 2020/10/16 上午7:48
 */
public class Solution2 {

    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length-1;
        int[] res = new int[A.length];
        int index = A.length-1;
        while (left <= right){
            if (-A[left] > A[right]) {
                res[index--] = A[left]*A[left];
                left++;
            }
            else {
                res[index--] = A[right]*A[right];
                right--;
            }
        }

        return res;
    }
}
```

![image-20201016080432123](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201016080432123.png)