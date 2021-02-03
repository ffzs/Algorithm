## [480. 滑动窗口中位数](https://leetcode-cn.com/problems/sliding-window-median/)

## 题目

中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。

```java
例如：

[2,3,4]，中位数是 3
[2,3]，中位数是 (2 + 3) / 2 = 2.5
给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。

示例：

给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。

窗口位置                      中位数

---------------               -----

[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7      -1
 1  3 [-1  -3  5] 3  6  7      -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
```

 

```java
提示：

你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
```


链接：https://leetcode-cn.com/problems/sliding-window-median

## 解题记录

+ 暴力解法，直接截取窗口，然后排序，取中位数

```java
/**
 * @author: ffzs
 * @Date: 2021/2/3 下午6:07
 */
public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int left = 0, right = k-1;
        boolean isEven = (k&1) == 0;
        while (right < nums.length) {
            int[] tmp = Arrays.copyOfRange(nums, left, right+1);
            Arrays.sort(tmp);
            int mid = (right - left) >>> 1;
            if (isEven) {
                res[left] = ((long)tmp[mid] + tmp[mid+1])/2D;
            }else{
                res[left] = tmp[mid];
            }
            left++;
            right++;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.medianSlidingWindow(nums, 3)));
    }
}
```

![image-20210203191606027](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210203191606027.png)

## 进阶

通过使用大小堆维护中位数元素：

+ 如果小根堆的top，放入大根堆，否则放入小根堆
+ 偶数返回小根堆的top和大根堆的top的平均值，奇数的话返回小根堆的top
+ 删除策略使用延迟删除，通过一个map记录需要删掉的值情况，一旦两个堆的top有变化，就处理一下已经删掉的那些值，使top为未被删掉的值

```java
/**
 * @author: ffzs
 * @Date: 2021/2/3 下午7:52
 */

class DualHeap {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private Map<Integer, Integer> delayed;

    private boolean isOdd;
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.isOdd = (k&1) == 1;
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>(Comparator.naturalOrder());
        this.delayed = new HashMap<>();
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian(){
        return isOdd? small.peek() : ((long)small.peek() + large.peek()) / 2D;
    }

    public void insert(int num) {
        if (!delayed.containsKey(num)) delayed.put(num, 0);
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        }
        else {
            large.offer(num);
            largeSize++;
        }
        makeBalance();
    }

    public void erase(int num) {

        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) {
                small.poll();
                prune(small);
            }
            else delayed.put(num, delayed.get(num) + 1);
        }
        else {
            largeSize --;
            if (num == large.peek()) {
                large.poll();
                prune(large);
            }
            else delayed.put(num, delayed.get(num) + 1);
        }
        makeBalance();
    }

    private void makeBalance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--; largeSize++;
            prune(small);
        }
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++; largeSize--;
            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.get(num) > 0) {
                delayed.put(num, delayed.get(num) - 1);
                heap.poll();
            }
            else break;
        }
    }
}

public class Solution2 {
    public double[] medianSlidingWindow(int[] nums, int k) {

        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }

        double[] res = new double[nums.length - k + 1];

        res[0] = dh.getMedian();

        for (int i = k; i < nums.length; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i-k]);
            res[i - k + 1] = dh.getMedian();
        }

        return res;
    }
}
```

![image-20210203212458746](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210203212458746.png)