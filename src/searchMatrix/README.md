## [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/)

## 题目

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

```java
示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：

输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
```

```java
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
```


链接：https://leetcode-cn.com/problems/search-a-2d-matrix

## 解题记录

+ 首先二分查找，发现target范围的行
+ 然后通过二分查找，确定是否有该值
+ 注意两个二分查找的返回逻辑有些不同，需要差别对待

```java
/**
 * @author: ffzs
 * @Date: 2021/3/30 上午8:42
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m+1];
        for (int i = 0; i < m; i++) {
            rows[i] = matrix[i][0];
        }
        rows[m] = matrix[m-1][n-1];

        if (target < rows[0] || target > rows[m]) return false;

        int aim = biSearch(rows, 0, m, target, false);
        int[] row = matrix[aim];
        int idx = biSearch(row, 0, n-1, target, true);
        return row[idx] == target;
    }

    public int biSearch (int[] nums, int l, int r, int target, boolean isRow) {
        if (l >= r) return isRow? l: l-1;
        int mid = (l + r) >>> 1;
        System.out.println(mid);
        if (target > nums[mid]) return biSearch(nums, mid + 1, r, target, isRow);
        else if (target == nums[mid]) return mid;
        else return biSearch(nums, l, mid, target, isRow);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] row = {1,3};
//        int[] row = {1,3,5,7};
        System.out.println(solution.biSearch(row, 0, row.length -1, 3, false));
    }
}
```

![image-20210330103013747](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210330103013747.png)