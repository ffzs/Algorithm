## 869. 重新排序得到 2 的幂

## 题目

给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。

如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

```java
 示例 1：

输入：1
输出：true
示例 2：

输入：10
输出：false
示例 3：

输入：16
输出：true
示例 4：

输入：24
输出：false
示例 5：

输入：46
输出：true
```

```java
提示：

1 <= N <= 10^9
```


链接：https://leetcode-cn.com/problems/reordered-power-of-2

## 解题记录

+ 优先构造出所有的符合条件的2的幂情况
+ 然后通过统计n中所有的数值情况，看是否有和2的幂重合的情况
+ 当然也可以将2的幂的情况通过可hash的形式描述，然后直接通过set判断

```java
/**
 * @author: ffzs
 * @Date: 2021/10/28 上午7:32
 */
public class Solution {
    static Set<Integer> set = new HashSet<>();
    static {
        for (int cur = 1; cur <= (int)1e9+10; cur *= 2) {
            set.add(cur);
        }
    }
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = getCount(n);
        for (int i : set) {
            if (compare(cnt, getCount(i))) return true;
        }
        return false;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static private int[] getCount(int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        return cnt;
    }
}
```

![image-20211028075535072](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211028075535072.png)