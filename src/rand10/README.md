## 470. 用 Rand7() 实现 Rand10()

## 题目

已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

 

```java
示例 1:

输入: 1
输出: [7]
示例 2:

输入: 2
输出: [8,4]
示例 3:

输入: 3
输出: [8,1,10]


提示:

rand7 已定义。
传入参数: n 表示 rand10 的调用次数。
```

```java
进阶:

rand7()调用次数的 期望值 是多少 ?
你能否尽量少调用 rand7() ?
```



链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7



## 解题记录

+ 拒绝采样，通过`rand7*rand7`得到`1-49`的数值的概率是相同的
+ 通过将`1-40`数值通过计算分配到`1-10`的情况概率是相同的
+ 如果大于40则再次获取

```java
/**
 * @author: ffzs
 * @Date: 2021/9/5 上午7:21
 */
class SolBase{
    public int rand7(){
        return Math.round(6) + 1;
    }
}

public class Solution extends SolBase{
    public int rand10() {
        int r = 0;
        do {
            r = (rand7() - 1) * 7 + rand7();
        } while (r > 40);
        return r % 10 + 1;
    }
}
```

![image-20210905074407477](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210905074407477.png)