## [1207. 独一无二的出现次数](https://leetcode-cn.com/problems/unique-number-of-occurrences/)

## 题目

给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

 

```java
示例 1：

输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
示例 2：

输入：arr = [1,2]
输出：false
示例 3：

输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
输出：true
```


提示：

1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000


链接：https://leetcode-cn.com/problems/unique-number-of-occurrences

## 解题记录

+ 先统计出现情况，再统计出现情况是否重复

```java
/**
 * @author: ffzs
 * @Date: 2020/10/28 上午10:36
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counter = new int[2000];
        for (int i : arr) {
            counter[i+1000]++;
        }
        boolean[] unique = new boolean[1001];
        for (int i : counter) {
            if (i!=0) {
                if (!unique[i]) unique[i] = true;
                else return false;
            }
        }
        return true;
    }
}
```

![image-20201028104925641](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201028104925641.png)

+ 快速排序，这样相同的数值就在一起了，可以方便的统计数值个数，同时可以一有重复数量就停止

```java
class Solution2 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length==1) return true;
        boolean[] unique = new boolean[1001];
        Arrays.sort(arr);
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i+1 < arr.length && arr[i] == arr[i+1]) counter++;
            else {
                if (!unique[counter]) unique[counter] = true;
                else return false;
                counter = 1;
            }
        }
        return true;
    }
}
```

![image-20201028111156740](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201028111156740.png)