## [448. 找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)

## 题目

给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

```java
示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
```


链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array

## 解题记录

+ 不考虑额外空间的话，直接通过一个tmp记录出现情况，之后再将没有出现过的放到list中即可

```java
/**
 * @author: ffzs
 * @Date: 2021/2/13 上午8:52
 */
public class Solution2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        boolean[] tmp = new boolean[n + 1];

        for (int num : nums) {
            tmp[num] = true;
        }

        for (int i = 1; i < tmp.length; i++) {
            if (!tmp[i]) res.add(i);
        }

        return res;
    }
}
```

![image-20210213091108872](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210213091108872.png)



+ 要求不适用额外空间的话，可以优先进行排序，然后再通过判断前后关系去定缺失情况，将缺失的放到list中

```java
/**
 * @author: ffzs
 * @Date: 2021/2/13 上午8:34
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(nums);

        if (nums[0] != 1) {
            for (int i = 1; i < nums[0]; i++) {
                res.add(i);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 != nums[i]) {
                for (int j = nums[i-1] + 1; j < nums[i]; j++) {
                    res.add(j);
                }
            }
        }
        if (nums[n-1] != n) {
            for (int i = nums[n - 1] + 1; i <= n; i++) {
                res.add(i);
            }
        }
        return res;
    }

}
```

![image-20210213090452113](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210213090452113.png)