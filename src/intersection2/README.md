## [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

## 题目

给定两个数组，编写一个函数来计算它们的交集。

```java
示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
```

```java
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
```


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。


链接：https://leetcode-cn.com/problems/intersection-of-two-arrays

## 解题记录

+ 暴力解法
+ 直接双循环，将一样的放到set里，然后将set转化为数组

```java
/**
 * @author: ffzs
 * @Date: 2020/11/2 上午11:49
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> tmp = new HashSet<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                if (i==i1) tmp.add(i);
            }
        }
        int[] res = new int[tmp.size()];
        int i = 0;
        for (Integer integer : tmp) {
            res[i++] = integer;
        }
        return res;
    }

}
```

![image-20201102123531974](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201102123531974.png)

+ 通过set存储短的数组中数，方便比对是否相同

```java
/**
 * @author: ffzs
 * @Date: 2020/11/2 下午12:36
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        if (nums1.length> nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        for (int i : nums1) set1.add(i);

        for (int i : nums2) {
            if (set1.contains(i)) set2.add(i);
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i++] = integer;
        }
        return res;
    }
}
```

![image-20201102124242014](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201102124242014.png)