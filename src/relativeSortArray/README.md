## [1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)

## 题目

给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

```java
示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
```


提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中

链接：https://leetcode-cn.com/problems/relative-sort-array



## 解题记录

+ 通过计数排序统计arr1中各个数据的出现次数
+ 通过arr2中顺序获取获取个数，然后通过个数填到arr1中，然后设置count为0
+ 之后再将counter中不是0的填到arr1中

```java
/**
 * @author: ffzs
 * @Date: 2020/11/14 上午9:39
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] counter = new int[1001];
        for (int i : arr1) {
            counter[i]++;
        }
        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < counter[i]; j++) {
                arr1[idx++]=i;
            }
            counter[i] = 0;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] !=0) {
                for (int i1 = 0; i1 < counter[i]; i1++) {
                    arr1[idx++] = i;
                }
            }
        }
        return arr1;
    }
}
```

![image-20201114100441718](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201114100441718.png)