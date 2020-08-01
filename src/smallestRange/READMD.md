## [632. 最小区间](https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/)

## 题目

你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

```java
示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释: 
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
```

```java
注意:

给定的列表可能包含重复元素，所以在这里升序表示 >= 。
1 <= k <= 3500
-105 <= 元素的值 <= 105
对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
```


链接：https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists



## 解题记录

### 小根堆

+ 因为每一个数组都是升序的
+ 每一个列表分配一个指针，通过堆维护一个排序的最小值，最大值
+ 通过比对max-min的区间更新返回值
+ 每次处理之后，右移最小值列表的index，进入下一次比较
+ 知道有列表的指针超出范围



```java
/**
 * @author ffzs
 * @describe
 * @date 2020/8/1
 */

public class Solution {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        if (n == 0) return new int[2];
        // 记录列表们中指针位置
        int[] idxes = new int[n];
        // 通过堆记录目前所有列表中最小值位置
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> nums.get(i).get(idxes[i])));

        int max = Integer.MIN_VALUE;
        // 获得初始最大和最小
        for (int i = 0; i < n; i++) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        int min = nums.get(queue.peek()).get(0);
        int[] res = {min, max};
        int range = max - min;
        while (true) {
            int minL = queue.poll();
            // 获取堆中最小值
            min = nums.get(minL).get(idxes[minL]);
            // 判断区间大小，以更换区间
            if (max - min < range) {
                range = max - min;
                res = new int[]{min, max};
            }
            // 最小值指针右移
            idxes[minL] ++;
            // 如果某个列表数据取完，那么结束循环
            if (idxes[minL] == nums.get(minL).size()) break;
            // 更新堆中排序
            queue.offer(minL);
            // 更新最大值
            max = Math.max(max, nums.get(minL).get(idxes[minL]));
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4,10,15,24,26));
        nums.add(List.of(0,9,12,20));
        nums.add(List.of(5,18,22,30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}

```

![image-20200801084836390](READMD.assets/image-20200801084836390.png)

### 哈希表

+ 通过将所有数组的值取出，放到一起，通过哈希关联原列表
+ 然后将这些值排序，选定区间，使得区间中数值涵盖所有原列表，就是说原列表中数值至少有一个
+ 区间大小进行比较最优
+ 通过丢弃目前最小值，进行移动区间，通过扩充保证区间仍然有丢弃数组对应数组



```java
/**
 * @author ffzs
 * @describe
 * @date 2020/8/1
 */
public class Solution3 {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int len = nums.stream().map(List::size).reduce(Integer::sum).get();
        int[][] ns = new int[len][2];
        int i = 0, j = 0;
        for(List<Integer> list : nums){
            for(Integer num : list){
                ns[i][0] = num;
                ns[i][1] = j;
                i++;
            }
            j++;
        }

        Arrays.sort(ns,Comparator.comparingInt(v -> v[0]));  // 重新排序

        int[] res = new int[]{ns[0][0], ns[len-1][0]};
        int l=0, r=0, k=0;
        int[] counter = new int[n];
        int range = res[1] - res[0];
        while (r < len) {
            if (counter[ns[r][1]]++ == 0) k++;
            if (k == n) {
                while (counter[ns[l][1]] > 1) counter[ns[l++][1]]--;  // 跳过最小值所在列表中值不唯一情况
                int curRange = ns[r][0] - ns[l][0];
                if (curRange < range || (curRange == range && ns[l][0] < res[0])) {
                    range = curRange;
                    res = new int[] {ns[l][0], ns[r][0]};
                }
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(List.of(4,10,15,24,26));
        nums.add(List.of(0,9,12,20));
        nums.add(List.of(5,18,22,30));
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}

```

![image-20200801094718975](READMD.assets/image-20200801094718975.png)