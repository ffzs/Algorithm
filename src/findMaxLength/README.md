## 525. 连续数组

## 题目

给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

 

```java
示例 1:

输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:

输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
```



```java
提示：

1 <= nums.length <= 105
nums[i] 不是 0 就是 1
```


链接：https://leetcode-cn.com/problems/contiguous-array

## 解题记录

+ 前缀和，通过数组存储每一位的0,1情况
+ 然后遍历取件求出每一个起始终止的情况，如果0,1个数相同的话那么就记录一下，比较最大值

```java
/**
 * @author: ffzs
 * @Date: 2021/6/3 上午7:31
 */
public class Solution {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // [c0, c1]
        int[][] counter = new int[n+1][2];

        for (int i = 0; i < n; i++) {
            counter[i+1][0] = counter[i][0];
            counter[i+1][1] = counter[i][1];
            if (nums[i]==0) counter[i+1][0]++;
            else counter[i+1][1]++;
        }

        int res = 0;
        for (int i = n; i > res; i--) {
            for (int j = 0; j < i-1; j++) {
                if ((counter[i][0] - counter[j][0]) == (counter[i][1]-counter[j][1])) res = Math.max(res, i-j);
            }
        }
        return res;
    }

}
```

![image-20210603075354450](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210603075354450.png)

超时了

+ 换一种思路，我们维护一个0,1的count， 1加一， 0减一， 那么为0的时候说明0,1相同
+ 通过一个hash维护counter，同样前缀和的方式，找到最大的距离

```java
/**
 * @author: ffzs
 * @Date: 2021/6/3 上午7:42
 */
public class Solution2 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>() {{
            put(0, -1);
        }};
        int counter = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) counter++;
            else counter--;

            if (map.containsKey(counter)) res = Math.max(res, i - map.get(counter));
            else map.put(counter, i);
        }

        return res;
    }

}
```

![image-20210603075621968](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210603075621968.png)