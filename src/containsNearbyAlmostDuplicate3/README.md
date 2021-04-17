## 220. 存在重复元素 III

## 题目

给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在两个下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。

如果存在则返回 true，不存在返回 false。

```java
 示例 1：

输入：nums = [1,2,3,1], k = 3, t = 0
输出：true
示例 2：

输入：nums = [1,0,1,1], k = 1, t = 2
输出：true
示例 3：

输入：nums = [1,5,9,1,5,9], k = 2, t = 3
输出：false
```

```java
提示：

0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1
```


链接：https://leetcode-cn.com/problems/contains-duplicate-iii

## 解题记录

+ 滑动窗口解题，通过维护一个窗口内部的值来判断，窗口内是否有满足要求的值
+ 移动窗口的时候直接删去移除值即可
+ 这里有个隐含的条件就是，如果窗口内存在两个相同的值那么，`abs(nums[i]-nums[j])=0`是一定会$<=t$则一定会return

```java
/**
 * @author: ffzs
 * @Date: 2021/4/17 上午8:40
 */
public class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        int n = nums.length;
        if (n == 0 || k == 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        set.add((long)nums[0]);
        for (int i = 1; i < n; i++) {
            Long upper = set.ceiling((long)nums[i]-t);
            if (upper != null && upper <= (long)nums[i] + t) return true;
            set.add((long)nums[i]);
            if (i >= k) set.remove((long)nums[i-k]);
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {4,1,6,3};
        Solution2 s = new Solution2();
        System.out.println(s.containsNearbyAlmostDuplicate(nums, 100, 1));
    }
}
```

![image-20210417101134708](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210417101134708.png)



## 进阶

+ 通过桶排序的方法，将数组分成一个个t长的桶，那么被分到一个桶内的数之间的abs肯定$<=t$，再通过维护一个k长的窗口
+ 当然也有可能在桶左右两边的桶有符合条件的情况，因此也要检查

```java
/**
 * @author: ffzs
 * @Date: 2021/4/17 上午8:15
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<>();
        long w = t +1L;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) return true;
            if (map.containsKey(id-1) && Math.abs(map.get(id-1)-nums[i])<=t) return true;
            if (map.containsKey(id+1) && Math.abs(map.get(id+1)-nums[i])<=t) return true;
            map.put(id, (long)nums[i]);
            if (i >= k) map.remove(getId(nums[i-k], w));
        }
        return false;
    }

    private long getId(int num, long w) {
        return num>=0?num/w:(num+1)/w-1;
    }
}
```

![image-20210417101101373](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210417101101373.png)