## 810. 黑板异或游戏

## 题目

黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）

换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。

假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。 

```java
示例：

输入: nums = [1, 1, 2]
输出: false
解释: 
Alice 有两个选择: 擦掉数字 1 或 2。
如果擦掉 1, 数组变成 [1, 2]。剩余数字按位异或得到 1 XOR 2 = 3。那么 Bob 可以擦掉任意数字，因为 Alice 会成为擦掉最后一个数字的人，她总是会输。
如果 Alice 擦掉 2，那么数组变成[1, 1]。剩余数字按位异或得到 1 XOR 1 = 0。Alice 仍然会输掉游戏。
```

```java
提示：

1 <= N <= 1000
0 <= nums[i] <= 2^16
```


链接：https://leetcode-cn.com/problems/chalkboard-xor-game

## 解题记录

+ 逻辑推理，因为先手优势，如果是偶数个，那么最后一个一定是Bob的，那么Alice就可以控制自己选择情况，不给bob异或为0
+ 当时奇数个的时候，Alice选最后一个，按道理应该同样，Alice总是输，但是有一种特殊情况，就是Bob怎么避免的话，最后都会剩一个0给Alice，也就是所有数值求异或之后为0的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/5/22 上午9:50
 */
public class Solution {

    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) return true;

        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res == 0;
    }
}
```

![image-20210522133235129](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210522133235129.png)

+ 使用stream的一行写法

```java
/**
 * @author: ffzs
 * @Date: 2021/5/22 下午1:33
 */
public class Solution2 {

    public boolean xorGame(int[] nums) {
        return nums.length % 2 == 0 || Arrays.stream(nums).boxed().reduce((a,b) -> a^b).get() == 0;
    }
}
```

![image-20210522133449282](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210522133449282.png)