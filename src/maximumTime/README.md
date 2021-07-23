## 1736. 替换隐藏数字得到的最晚时间

## 题目

给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。

有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。

替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。

 

```java
示例 1：

输入：time = "2?:?0"
输出："23:50"
解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
示例 2：

输入：time = "0?:3?"
输出："09:39"
示例 3：

输入：time = "1?:22"
输出："19:22"


提示：

time 的格式为 hh:mm
题目数据保证你可以由输入的字符串生成有效的时间
```


链接：https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits

## 解题记录

+ 通过判断各个位置可能出现的？情况做相应的处理

```java
public class Solution {

    public String maximumTime(String time) {
        char[] cs = time.toCharArray();

        if (cs[0] == '?') {
            if (cs[1] == '?') {
                cs[0] = '2';
                cs[1] = '3';
            }
            else if (cs[1] - '0' <=3 ){
                cs[0] = '2';
            }
            else cs[0] = '1';
        }
        if (cs[1] == '?') {
            if (cs[0] == '2') cs[1] = '3';
            else cs[1] = '9';
        }
        if (cs[3] == '?') {
            cs[3] = '5';
        }
        if (cs[4] == '?') cs[4] = '9';

        return new String(cs);
    }

}
```

![image-20210724074320382](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210724074320382.png)