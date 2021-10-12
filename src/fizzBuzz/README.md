## 412. Fizz Buzz

## 题目

写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

```java
示例：

n = 15,

返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
```


链接：https://leetcode-cn.com/problems/fizz-buzz

## 解题记录

+ 没啥好说的

```java
/**
 * @author: ffzs
 * @Date: 2021/10/13 上午7:07
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) res.add("FizzBuzz");
            else if (i % 5 == 0) res.add("Buzz");
            else if (i % 3 == 0) res.add("Fizz");
            else res.add(String.valueOf(i));
        }
        return res;
    }

}
```

![image-20211013072237553](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211013072237553.png)