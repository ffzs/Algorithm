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
+ 但是这种用法不符合空间复杂度要求

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

## 进阶

+ 第一个方法中因为用了新的数组，因此没有满足空间复杂度的要求
+ 因此我们需要想一个方法直接使用原数组进行信息的记录
+ 因为最小为出现正整数不可能大于len，我们可以将nums中小于等于len这部分数进行标记，最直接的方法就是变成负数，通过判断第一个不是负数的即可
+ 但是又一个问题就是有的数值本身就是负数，要排除掉这部分的影响
+ 因为这部分负数直接不影响对最终值的判断，那么直接把这部分值通过范围以外的任何数代替即可

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/27
 */
public class Solution3 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = nums.length + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= nums.length){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return i+1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(num));
    }
}

```

![image-20200627130257424](README.assets/image-20200627130257424.png)

可见如果排序是通过快速排序logN的话速度不一定比循环两次的2N速度慢



