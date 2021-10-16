## 282. 给表达式添加运算符

## 题目

给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。

```java
示例 1:

输入: num = "123", target = 6
输出: ["1+2+3", "1*2*3"] 
示例 2:

输入: num = "232", target = 8
输出: ["2*3+2", "2+3*2"]
示例 3:

输入: num = "105", target = 5
输出: ["1*0+5","10-5"]
示例 4:

输入: num = "00", target = 0
输出: ["0+0", "0-0", "0*0"]
示例 5:

输入: num = "3456237490", target = 9191
输出: []
```

```java
提示：

1 <= num.length <= 10
num 仅含数字
-231 <= target <= 231 - 1
```


链接：https://leetcode-cn.com/problems/expression-add-operators

## 解题记录

+ 通过回溯算法对每一种切分数字和数值之间进行符号填充进行计算，找到符合target的情况
+ 这里需要注意的是 * 的时候需要 因为加减后于乘法，因此需要还原之间的结果在加和，所以需要保留上一步的加和情况

```java
/**
 * @author: ffzs
 * @Date: 2021/10/16 上午7:27
 */

public class Solution {
    List<String> res = new ArrayList<>();
    char[] cs;
    int target;
    int n;
    public List<String> addOperators(String num, int target) {
        this.cs = num.toCharArray();
        this.target = target;
        this.n = num.length();
        backtrack(new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void backtrack(StringBuilder sb, int i, long ret, long mul) {
        if (i == n) {
            if (ret == target) res.add(sb.toString());
            return;
        }

        int index = sb.length();
        if (i > 0) sb.append(0);

        long val = 0;
        for (int j = i; j < n && (j == i || cs[i] != '0'); j++) {
            val = val * 10 + cs[j] - '0';
            sb.append(cs[j]);
            if (i == 0) backtrack(sb, j + 1, val, val);
            else {
                sb.setCharAt(index, '+');
                backtrack(sb, j + 1, ret + val, val);
                sb.setCharAt(index, '-');
                backtrack(sb, j + 1, ret - val, -val);
                sb.setCharAt(index, '*');
                backtrack(sb, j + 1, ret - mul + val * mul, val * mul);
            }
        }
        sb.setLength(index);
    }

}
```

![image-20211016080231663](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211016080231663.png)

+ 由于最终的返回字符串长度不会大于2倍的num的长度，这里可以通过使用一个`char[]`存储结果

