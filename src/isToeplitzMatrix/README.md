## [766. 托普利茨矩阵](https://leetcode-cn.com/problems/toeplitz-matrix/)

## 题目

给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。

如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

```java
示例 1：


输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
输出：true
解释：
在上述矩阵中, 其对角线为: 
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
各条对角线上的所有元素均相同, 因此答案是 True 。
示例 2：

输入：matrix = [[1,2],[2,2]]
输出：false
解释：
对角线 "[1, 2]" 上的元素不同。
```

```java
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99
```

```java
进阶：

如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
```


链接：https://leetcode-cn.com/problems/toeplitz-matrix

## 解题记录

+ 直接遍历数组通过判断每一个斜线上的数值是否相同即可

```java
/**
 * @author: ffzs
 * @Date: 2021/2/22 下午4:56
 */
public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < n - 1; i++) {
            int cur = matrix[0][i];
            for (int j = 1; j < m; j++) {
                if (i + j < n && matrix[j][j + i] != cur) return false;
            }
        }

        for (int i = 1; i < m - 1; i++) {
            int cur = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (i + j < m && matrix[i + j][j] != cur) return false;
            }
        }
        return true;
    }
}
```

![image-20210222174647348](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210222174647348.png)