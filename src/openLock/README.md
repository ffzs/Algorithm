## 752. 打开转盘锁

## 题目

你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

```java
示例 1:
输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
    
示例 2:
输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
    
示例 3:
输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
    
示例 4:
输入: deadends = ["0000"], target = "8888"
输出：-1
```



```java
提示：

死亡列表 deadends 的长度范围为 [1, 500]。
目标数字 target 不会在 deadends 之中。
每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
```


链接：https://leetcode-cn.com/problems/open-the-lock

## 解题记录

+ 双向BFS处理，没转动一次的下一层都是有分支的，类似一个树形结构
+ 通过从起点"0000"到终点target过程，通过双向遍历，其中有一些节点不能够到达直接跳过即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/25 上午6:56
 */
public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int res = 0;
        set1.add("0000");
        set2.add(target);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String cur : set1) {

                if (deads.contains(cur)) continue;
                if (set2.contains(cur)) return res;
                visited.add(cur);

                for (int i = 0; i < 4; i++) {
                    String add_one = get_next(cur, i, true);
                    if (!visited.contains(add_one)) tmp.add(add_one);
                    String minus_one = get_next(cur, i, false);
                    if (!visited.contains(minus_one)) tmp.add(minus_one);
                }
            }
            res ++;
            set1 = set2;
            set2 = tmp;
        }

        return -1;

    }

    private String get_next(String it, int i, boolean add_one){
        char[] cur = it.toCharArray();
        if (add_one) {
            if (cur[i] == '9') cur[i] = '0';
            else cur[i] += 1;
        }
        else{
            if (cur[i] == '0') cur[i] = '9';
            else cur[i] -= 1;
        }
        return new String(cur);
    }

}
```

![image-20210625073219032](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210625073219032.png)