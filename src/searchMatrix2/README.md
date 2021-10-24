## 240. 搜索二维矩阵 II

## 题目

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。


示例 1：


输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
示例 2：


输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false


提示：

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-109 <= target <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解题记录

+ 由于是每行每列都是有序的
+ 从上向下查找，如果该数值小于$matrix[0][i]$那么他一定小于$matrix[1][i]$因此这样可以缩小查找的范围
+ 由于当row=1的时候该值更接近$matrix[1][i]$因此这里选着从后向前遍历
+ 当然在范围内部可以使用二分查找
+ 也可以找大于该值的数

```java
/**
 * @author: ffzs
 * @Date: 2021/10/25 上午7:14
 */
public class Solution {
    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return search(0, matrix[0].length-1);
    }

    private boolean search(int row, int col) {
        if (row >= matrix.length) return false;
        for (int i = col; i >= 0; i--) {
            int cur = matrix[row][i];
            if (cur == target) return true;
            else if (cur < target) return search(row + 1, i);
        }
        return false;
    }

}
```

![image-20211025073048028](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211025073048028.png)