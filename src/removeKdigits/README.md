## [402. 移掉K位数字](https://leetcode-cn.com/problems/remove-k-digits/)

## 题目

给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。

```java
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。
```



链接：https://leetcode-cn.com/problems/remove-k-digits



## 解题记录

+ 因为是一个数字的缘故，位数越高权重越大，能影响整个数值大小的能力也就越大
+ 因此从头到尾，通过栈进行存储，每次添加的时候进行比较，大于且k还大于0的时候将这部分大于的移去

```java
/**
 * @author: ffzs
 * @Date: 2020/11/15 上午11:52
 */
public class Solution2 {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        char[] cs = num.toCharArray();
        int n = cs.length -k ;
        for (char c : cs) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char it = deque.pollFirst();
            if (!(sb.length()==0 && it == '0')) sb.append(it);
        }
        return sb.length()==0 ? "0":sb.toString();
    }
}
```

![image-20201115121359119](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201115121359119.png)