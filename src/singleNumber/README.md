## 137. 只出现一次的数字 II

## 题目

给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

 

```java
示例 1：

输入：nums = [2,2,3,2]
输出：3
示例 2：

输入：nums = [0,1,0,1,0,1,99]
输出：99
```



```java
提示：

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次


进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
```


链接：https://leetcode-cn.com/problems/single-number-ii

## 解题记录

+ 通过map记录，然后通过检查哪个只出现一次返回

```java
/**
 * @author: ffzs
 * @Date: 2021/4/30 下午12:32
 */
public class Solution2 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) return item.getKey();
        }
        return nums[0];
    }

}
```

![image-20210430132745591](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210430132745591.png)

+ 通过对数组进行排序，然后再比较每一个数的前后两个数如果都不相同说明该数为只出现一次

```java
/**
 * @author: ffzs
 * @Date: 2021/4/30 下午12:21
 */
public class Solution {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        if (n == 1 || nums[0] != nums[1]) return nums[0];

        for (int i = 1; i < n; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) return nums[i];
        }

        return nums[n-1];
    }

}
```

![image-20210430132922892](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210430132922892.png)

+ 通过位运算，之前有做过重复个数为2的情况，直接通过异或运算可以直接将相同的两个数抵消掉，最终只保留唯一一个出现一次的数
+ 这个同理，通过两个数构建一个3进制表示，分别通过(0,0),(0,1),(1,0)来表示0,1,2;
+ 每次循环通过更改两个数值来对相应位值进行抵消，2->0， 3个一周期

```java
/**
 * @author: ffzs
 * @Date: 2021/4/30 下午1:04
 */
public class Solution3 {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = ~b & (a ^ num);
            b = ~a & (b ^ num);
        }

        return a;
    }

}
```

![image-20210430133743003](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210430133743003.png)