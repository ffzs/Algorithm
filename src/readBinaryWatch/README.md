## 401. 二进制手表

## 题目

二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。

例如，下面的二进制手表读取 "3:25" 。


（图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）

给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。

小时不会以零开头：

例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
分钟必须由两位数组成，可能会以零开头：

例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。

```java
示例 1：

输入：turnedOn = 1
输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
示例 2：

输入：turnedOn = 9
输出：[]
```

```java
解释：
0 <= turnedOn <= 10
```


链接：https://leetcode-cn.com/problems/binary-watch

## 解题记录

+ 通过回溯的方法进行处理
+ 因为灯的情况比较少，因此将分钟和小时分别累加处理即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/21 上午7:24
 */
public class Solution2 {
    List<String> res = new ArrayList<>();
    int[] hours = {1,2,4,8,0,0,0,0,0,0};
    int[] minutes = {0,0,0,0,1,2,4,8,16,32};

    public List<String> readBinaryWatch(int turnedOn) {
        dfs(turnedOn, 0, 0, 0);
        return res;
    }

    private void dfs (int num, int index, int hour, int minute) {
        if (hour >= 12 || minute >= 60) return;
        if (num == 0) {
            StringBuilder sb = new StringBuilder().append(hour).append(":").append(minute<10?"0":"").append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            dfs(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}
```

![image-20210621073612907](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210621073612907.png)

