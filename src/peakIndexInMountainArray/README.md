## 852. 山脉数组的峰顶索引

## 题目

符合下列属性的数组 arr 称为 山脉数组 ：
arr.length >= 3
存在 i（0 < i < arr.length - 1）使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

 

```java
示例 1：
输入：arr = [0,1,0]
输出：1
    
示例 2：
输入：arr = [0,2,1,0]
输出：1
    
示例 3：
输入：arr = [0,10,5,2]
输出：1
    
示例 4：
输入：arr = [3,4,5,1]
输出：2
    
示例 5：
输入：arr = [24,69,100,99,79,78,67,36,26,19]
输出：2
```



```java
提示：

3 <= arr.length <= 104
0 <= arr[i] <= 106
题目数据保证 arr 是一个山脉数组


进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
```


链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array

## 解题记录

+ 因为arr一定是一个山脉数组，因此可以通过二分法找到最高点



```java
/**
 * @author: ffzs
 * @Date: 2021/6/15 上午6:48
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < arr[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
```

![image-20210615065636610](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210615065636610.png)