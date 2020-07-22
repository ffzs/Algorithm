## [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

## 题目

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

```java
示例 1：

输入：[3,4,5,1,2]
输出：1
```

```java
示例 2：

输入：[2,2,2,0,1]
输出：0
```


链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof

## 解题记录

+ 是一个递增数组的旋转数组，因此是部分有序的
+ 寻找最小值的话，就是要找到断点，即 `nums[i-1]>nums[i]`

```java
/**
 * @author: ffzs
 * @Date: 2020/7/22 上午7:53
 */
public class Solution {
    public static int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length ; i++) {
            if (numbers[i-1] > numbers[i]) return numbers[i];
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }
}

```

![image-20200722080407520](README.assets/image-20200722080407520.png)

+ 还可以通过二分法进行搜索
+ 要处理mid和r相等的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/7/22 上午8:04
 */
public class Solution2 {
    public static int minArray(int[] numbers) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int mid = l+r >>> 1;
            if (numbers[mid] < numbers[r]) r = mid;
            else if (numbers[mid] > numbers[r]) l = mid+1;
            else r--;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }
}
```

![image-20200722082539336](README.assets/image-20200722082539336.png)