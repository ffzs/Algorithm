## 726. 原子的数量

## 题目

给定一个化学式formula（作为字符串），返回每种原子的数量。

原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。

如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。

两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。

一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。

给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。

```java
示例 1:

输入: 
formula = "H2O"
输出: "H2O"
解释: 
原子的数量是 {'H': 2, 'O': 1}。
示例 2:

输入: 
formula = "Mg(OH)2"
输出: "H2MgO2"
解释: 
原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
示例 3:

输入: 
formula = "K4(ON(SO3)2)2"
输出: "K4N2O14S4"
解释: 
原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
```

```java
注意:

所有原子的第一个字母为大写，剩余字母都是小写。
formula的长度在[1, 1000]之间。
formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
```


链接：https://leetcode-cn.com/problems/number-of-atoms

## 解题记录

+ 大小写问题大写字母后面的小写字符算是一组
+ 每一个括号内部进行递归处理
+ 最后再统计每组情况的个数，然后完成字符串



```java
/**
 * @author: ffzs
 * @Date: 2021/7/5 上午6:57
 */
public class Solution {

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = count(formula, 0 , formula.length()-1);
        List<String> arr = new ArrayList<>(map.keySet());
        arr.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            int v = map.get(s);
            sb.append(s);
            if (v > 1) sb.append(v);
        }
        return sb.toString();
    }

    private Map<String, Integer> count (String s, int l, int r) {
        Map<String, Integer> map = new HashMap<>();
        String v = "";

        for (int i = l; i <= r;) {
            if (Character.isDigit(s.charAt(i))) {
                int tmp = s.charAt(i) - '0';
                while (++i <= r && Character.isDigit(s.charAt(i))) {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                }
                map.put(v, map.getOrDefault(v, 0) + tmp);
            }
            else if (s.charAt(i) == '(') {
                int count = 1;
                i ++;
                int sl = i;
                while (i <= r && count != 0) {
                    if (s.charAt(i) == '(') count++;
                    else if (s.charAt(i) == ')') count--;
                    i++;
                }
                Map<String, Integer> tmpMap = count(s, sl, i-2);
                int times;
                if (i > r) times = 1;
                else if (Character.isDigit(s.charAt(i))) {
                    times = s.charAt(i) - '0';
                    while (++i <= r && Character.isDigit(s.charAt(i))) times = times*10 + s.charAt(i) - '0';
                }
                else times = 1;
                for (Map.Entry<String, Integer> entry : tmpMap.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * times);
                }
            }
            else {
                int sl = i;
                while (++i <= r && Character.isLowerCase(s.charAt(i)));
                v = s.substring(sl, i);
                if (i <= r && Character.isDigit(s.charAt(i))) {}
                else map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }
        return map;
    }

}
```

![image-20210705073158501](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210705073158501.png)