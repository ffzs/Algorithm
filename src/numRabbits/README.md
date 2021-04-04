## 781. 森林中的兔子

森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。

返回森林中兔子的最少数量。



```java
示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

输入: answers = [10, 10, 10]
输出: 11

输入: answers = []
输出: 0
```

```java
说明:

answers 的长度最大为1000。
answers[i] 是在 [0, 999] 范围内的整数。
```


链接：https://leetcode-cn.com/problems/rabbits-in-forest



## 解题记录

+ 优先通过计数得到兔子回答的不同结果
+ 如果两只兔子说了1,那么他们最少情况是说的1都是对方，但是如果三只兔子说了，那么认为2只以外的那只和这两只是不同颜色
+ 所以要对相同数值进行分组，也就是1对应是2只一组，2就是3只一组，以此类推

```java
/**
 * @author: ffzs
 * @Date: 2021/4/4 下午12:32
 */
public class Solution {

    public int numRabbits(int[] answers) {
        int[] counter = new int[999];
        for (int answer : answers) {
            counter[answer]++;
        }

        int res = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                int cur = counter[i];
                res += (cur%(i+1) == 0?cur/(i+1):cur/(i+1)+1)*(i+1);
            }
        }
        return res;
    }
}
```

![image-20210404124742084](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210404124742084.png)