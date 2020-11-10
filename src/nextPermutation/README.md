## [31. 下一个排列](https://leetcode-cn.com/problems/next-permutation/)

## 题目

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

```java
以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```


链接：https://leetcode-cn.com/problems/next-permutation

## 解题记录

+ 这个题目看起来很费劲，不知道问得啥，后来看了下题解，其实就是给数组中的数可以组合出的所有数，看成一个字典，将字典排序，找到该数的下一个数，就是比该数大的数中，最小的那个。
+ 为了造成最小的变动的话，我们从右向左找，也就是可以理解为从右到左，先定为第一个区间，这个区间有比当前值更大的值，找到这个区间下一个更大值即为所求。
+ 从右往左确定第一个降序的位置，这个值和后面交换可以产生更大值
+ 再找该值右边仅小于该值的值，然后交换，此时该值右边为最大，将右边整个翻转变为最小即可

```JAVA
/**
 * @author: ffzs
 * @Date: 2020/11/10 上午9:14
 */

public class Solution {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i>=0){
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, nums.length-1);
    }

    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

![image-20201110102645551](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201110102645551.png)