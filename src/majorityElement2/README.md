## 229. 求众数 II

## 题目

给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。



```java
示例 1：

输入：[3,2,3]
输出：[3]
示例 2：

输入：nums = [1]
输出：[1]
示例 3：

输入：[1,1,1,3,3,2,2,2]
输出：[1,2]
```



```java
提示：

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
```


链接：https://leetcode-cn.com/problems/majority-element-ii

## 解题记录

+ 摩尔投票法，数组中能超过n/3的最多是有两个数值
+ 通过抵消的方式找到出现频率大于n/3的数值，也有可能是最后的数值，需要最后验证



```java
/**
 * @author: ffzs
 * @Date: 2021/10/22 上午7:18
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int p1 = 0, p2 = 0 ,v1 = 0, v2 = 0;
        for (int num : nums) {
            if (p1 == num) v1 ++;
            else if (p2 == num) v2 ++;
            else if (v1 == 0) {
                p1 = num;
                v1 = 1;
            }
            else if (v2 == 0) {
                p2 = num;
                v2 = 1;
            }
            else {
                v1--;
                v2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == p1) cnt1++;
            else if (num == p2) cnt2++;
        }
        if (cnt1 > n/3) res.add(p1);
        if (cnt2 > n/3) res.add(p2);
        return res;
    }
}
```

![image-20211022080424364](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211022080424364.png)