## [41. 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)

## 题目

给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

```java
示例 1:

输入: [1,2,0]
输出: 3
```

```java
示例 2:

输入: [3,4,-1,1]
输出: 2
```

```java
示例 3:

输入: [7,8,9,11,12]
输出: 1
```

```java
提示：

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
```


链接：https://leetcode-cn.com/problems/first-missing-positive

## 解题记录

+ 通过构建数组用来存储出现过的正整数，因为一个长度为n的数组中未出现的正整数不可能大于n+1，因此需要的是一个长度为n+2的数组，+2是因为还有0
+ 将数组范围出现过的数值记录，通过遍历记录数组第一个false即是没有出现的最大正整数
+ 如果为空的话直接返回1

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution {
    public static int firstMissingPositive(int[] nums) {
        boolean[] tmp = new boolean[nums.length+2];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                tmp[num] = true;
            }
        }
        for (int i = 1; i < tmp.length; i++) {
            if(!tmp[i]) return i;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] num = {1};
        System.out.println(firstMissingPositive(num));
    }
}
```

![image-20200627111316040](README.assets/image-20200627111316040.png)

+ 可以通过排序之后遍历
+ 如果大于res直接返回res因为res就是最小
+ 如果有res就+1
+ 但是因为排序的话时间并不满足题目要求

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution2 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for (int num : nums) {
            if (num > res) return res;
            else if (num == res) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {1};
        System.out.println(firstMissingPositive(num));
    }
}
```

![image-20200627113915825](README.assets/image-20200627113915825.png)