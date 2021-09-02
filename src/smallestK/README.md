## 面试题 17.14. 最小K个数

## 题目

设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

```java
示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
```



```java
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
```


链接：https://leetcode-cn.com/problems/smallest-k-lcci

## 解题记录

+ 快速排序
+ 通过选定数组的中间位置的值，然后左边大于该值的值和右边小于该值的值进行交换
+ 当保证前k个为顺序的情况下返回



```java
/**
 * @author: ffzs
 * @Date: 2021/9/3 上午6:42
 */
public class Solution {

    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) return arr;
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    static private void quickSort(int[] lst, int l, int r, int k) {
        if (l >= r) return;

        int mid = (l + r) >>> 1;

        int key = lst[mid];
        lst[mid] = lst[l];
        lst[l] = key;

        int ll = l, rr = r;
        while (ll < rr) {
            while (ll < rr && lst[rr] >= key) --rr;
            lst[ll] = lst[rr];
            while (ll < rr && lst[ll] <= key) ++ll;
            lst[rr] = lst[ll];
        }
        lst[ll] = key;
        if (ll > k) quickSort(lst, l, ll -1, k);
        else if (ll == k) return;
        else quickSort(lst, ll + 1, r, k);
    }

}
```

![image-20210903070603389](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210903070603389.png)