## [350. 两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)

## 题目

给定两个数组，编写一个函数来计算它们的交集。

```java
示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
```

```java
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
```

```java
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
```

```java
进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
```


链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii



## 解题方法

+ 使用hash表统计两个数组的数量
+ 通过比对两个map中key，并获取比较小的数量，然后写入数组返回

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/13
 */
public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        if (nums2.length > nums1.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Map<Integer, Integer> mL = getCountMap(nums1), mS = getCountMap(nums2);

        int counter = 0;
        for (Integer integer : mS.keySet()) {
            if (mL.containsKey(integer)) {
                int c = Math.min(mS.get(integer), mL.get(integer)) + counter;
                while (counter < c) res[counter++] = integer;
            }
        }
        return Arrays.copyOf(res, counter);
    }

    private static Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5},  nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}

```

![image-20200713224103262](README.assets/image-20200713224103262.png)

## 进阶

+ 通过对两个数组进行排序之后再进行比较

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/13
 */
public class Solution2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5},  nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}

```

![image-20200713224849393](README.assets/image-20200713224849393.png)