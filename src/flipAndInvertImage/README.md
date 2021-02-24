## [832. 翻转图像](https://leetcode-cn.com/problems/flipping-an-image/)

## 题目

给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。

水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。

反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。

```java
示例 1:
输入: [[1,1,0],[1,0,1],[0,0,0]]
输出: [[1,0,0],[0,1,0],[1,1,1]]
解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
     然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

示例 2:
输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
     然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
```

```java
说明:

1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1
```


链接：https://leetcode-cn.com/problems/flipping-an-image

## 解题记录

+ 一行一行翻转就可以了，先水平翻转，然后再变换
+ 注意中间的值也要处理

```java
/**
 * @author: ffzs
 * @Date: 2021/2/24 上午8:22
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            swap(ints);
        }
        return A;
    }

    private void swap(int[] row){
        int l = 0, r = row.length - 1;
        while (l < r) {
            int tmp = row[l];
            row[l++] = reverse(row[r]);
            row[r--] = reverse(tmp);
        }
        if (l == r) row[l] = reverse(row[l]);
    }

    private int reverse(int i) {
        return 1-i;
    }

}
```

![image-20210224084620589](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210224084620589.png)