## 1442. 形成两个异或相等数组的三元组数目

## 题目

给你一个整数数组 arr 。

现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。

a 和 b 定义如下：

```
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
```


注意：^ 表示 按位异或 操作。

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。

```java
示例 1：
输入：arr = [2,3,1,6,7]
输出：4
解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
    
示例 2：
输入：arr = [1,1,1,1,1]
输出：10
    
示例 3：
输入：arr = [2,3]
输出：0
    
示例 4：
输入：arr = [1,3,5,7,9]
输出：3
    
示例 5：
输入：arr = [7,11,12,9,5,2,7,17,22]
输出：8
```



```java
提示：

1 <= arr.length <= 300
1 <= arr[i] <= 10^8
```


链接：https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

## 解题记录

+ 通过前缀和求出所有情况total，然后再遍历i，j，k获取区域情况进行比较

```java
/**
 * @author: ffzs
 * @Date: 2021/5/18 上午8:40
 */
public class Solution {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] total = new int[n + 1];

        total[0] = 0;
        for (int i = 1; i <= n; i++) {
            total[i] = total[i-1]^arr[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if ((total[j - 1] ^ total[i - 1]) == (total[k - 1] ^ total[j-2])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
```

![image-20210518091817228](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210518091817228.png)

+ 由于 a== b 那么一定 a^b == 0
+ 可以找到a^b == 0的情况， 然后中间的值都可以为j

```java
/**
 * @author: ffzs
 * @Date: 2021/5/18 上午9:13
 */
public class Solution2 {

    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int k = i + 1; k < n; k++) {
                total ^= arr[k];
                if (total == 0) res += k - i;
            }
        }

        return res;
    }

}
```

![image-20210518092034504](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210518092034504.png)