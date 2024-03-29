## 881. 救生艇

## 题目

第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

 

```java
示例 1：

输入：people = [1,2], limit = 3
输出：1
解释：1 艘船载 (1, 2)
示例 2：

输入：people = [3,2,2,1], limit = 3
输出：3
解释：3 艘船分别载 (1, 2), (2) 和 (3)
示例 3：

输入：people = [3,5,3,4], limit = 5
输出：4
解释：4 艘船分别载 (3), (3), (4), (5)
```



```java
提示：

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
```


链接：https://leetcode-cn.com/problems/boats-to-save-people

## 解题记录

+ 先排序
+ 因为最多可以装2个人，那么可以通过双指针进行填充

```java
/**
 * @author: ffzs
 * @Date: 2021/8/26 上午6:49
 */
public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int res = 0;
        while (l <= r){
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        return res;
    }

}
```

![image-20210826070444993](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210826070444993.png)