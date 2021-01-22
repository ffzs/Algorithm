## [989. 数组形式的整数加法](https://leetcode-cn.com/problems/add-to-array-form-of-integer/)

## 题目

对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

 

```java
示例 1：

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
示例 2：

输入：A = [2,7,4], K = 181
输出：[4,5,5]
解释：274 + 181 = 455
示例 3：

输入：A = [2,1,5], K = 806
输出：[1,0,2,1]
解释：215 + 806 = 1021
示例 4：

输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
输出：[1,0,0,0,0,0,0,0,0,0,0]
解释：9999999999 + 1 = 10000000000
```

```java
提示：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
如果 A.length > 1，那么 A[0] != 0
```


链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer

## 解题记录

+ 直接一边对k求位数值，一边对A中数值加和
+ 值得注意的是，最好使用LinkedList处理，在list前添加是比较省时的

```java
/**
 * @author: ffzs
 * @Date: 2021/1/22 上午8:12
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int re = 0, i = A.length-1;
        LinkedList<Integer> res = new LinkedList<>();
        while (i >= 0 || K != 0 || re != 0) {
            int remain = K % 10;
            K /= 10;
            int num = i >= 0 ? remain + A[i] + re : remain + re;
            res.addFirst(num % 10);
            re = num / 10;
            i--;
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,2,0,0};
        System.out.println(solution.addToArrayForm(A, 34));
    }
}
```

![image-20210122090936587](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210122090936587.png)