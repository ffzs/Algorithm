## [861. 翻转矩阵后的得分](https://leetcode-cn.com/problems/score-after-flipping-matrix/)

## 题目

有一个二维矩阵 A 其中每个元素的值为 0 或 1 。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。

 

```java
示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
```


提示：

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] 是 0 或 1


链接：https://leetcode-cn.com/problems/score-after-flipping-matrix

## 解题记录

+ 因为是二进制，无论行号光看列的话，每一列代表的大小都已相同的，只要最一列1多就好
+ 对于行来看则要求每一行的第一个为1
+ 整体逻辑就是先每行调整为第一个为1,然后每列根据1的个数调整为1的个数大于等于一半即可

```java
/**
 * @author: ffzs
 * @Date: 2020/12/7 上午8:04
 */
public class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) turnRow(A[i]);
        }

        for (int i = 1; i < A[0].length; i++) {
            turnColumn(A, i);
        }

        System.out.println(Arrays.deepToString(A));
        int res = 0;
        for (int[] ints : A) {
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != 0) res += 1<<(ints.length - i - 1);
            }
        }
        return res;
    }

    private void turnRow(int[] row){
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) row[i] = 1;
            else row[i] = 0;
        }
    }

    private void turnColumn(int[][] m, int col) {
        int count = 0;
        for (int[] ints : m) {
            if (ints[col] == 1) count++;
        }
        if (count >= m.length-count) return;
        for (int[] ints : m) {
            if (ints[col] == 0) ints[col] = 1;
            else ints[col] = 0;
        }
    }
}
```

![image-20201207083636672](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201207083636672.png)

+ 还可以不更改数组中的数值，通过直接收集计数

```java
/**
 * @author: ffzs
 * @Date: 2020/12/7 上午8:39
 */
public class Solution2 {
    public int matrixScore(int[][] A) {
        int res = 0;

        for (int i = 0; i < A[0].length; i++) {
            int ones = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][0] == 1) ones += A[j][i];
                else ones += (1 - A[j][i]);
            }
            if (ones < A.length - ones) ones = A.length - ones;
            res += ones * (1<<(A[0].length - i - 1));
        }

        return res;
    }
}
```

![image-20201207085352205](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201207085352205.png)