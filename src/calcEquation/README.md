## [399. 除法求值](https://leetcode-cn.com/problems/evaluate-division/)

## 题目

给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

```java
示例 1：

输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
条件：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
示例 2：

输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：

输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]
```

```java
提示：

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj 由小写英文字母与数字组成
```

链接：https://leetcode-cn.com/problems/evaluate-division


## 解题记录

+ 首先获取全部的字符情况，并通过一个map存储字符和index的映射关系
+ 通过一个矩阵记录两个字符之间的除法关系
+ 通过遍历所有字符情况，扩展间接关系的情况
+ 最后查找如果有的话就相应值，没有-1

```java
/**
 * @author: ffzs
 * @Date: 2021/1/6 下午8:37
 */
public class Solution2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();

        int index = 0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if(!map.containsKey(s)) map.put(s, index++);
            }
        }

        int n = map.size();
        double[][] tmp = new double[n][n];

        for (int i = 0; i < values.length; i++) {
            List<String> lst = equations.get(i);
            String a = lst.get(0), b = lst.get(1);
            int ai = map.get(a), bi = map.get(b);
            tmp[ai][bi] = values[i];
            tmp[bi][ai] = 1/values[i];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) tmp[i][j] = 1D;
                    else if (tmp[i][k] != 0 && tmp[k][j] != 0) {
                        tmp[i][j] = tmp[i][k] * tmp[k][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> lst = queries.get(i);
            String c = lst.get(0), d = lst.get(1);
            if (map.containsKey(c) && map.containsKey(d)) {
                int ci = map.get(c), di = map.get(d);
                res[i] = tmp[ci][di] != 0? tmp[ci][di]: -1;
            }
            else res[i] = -1;
        }

        return res;
    }

}
```

![image-20210106210042575](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210106210042575.png)