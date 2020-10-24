## [1024. 视频拼接](https://leetcode-cn.com/problems/video-stitching/)

## 题目

你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。

视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。

我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。

 

```java
示例 1：

输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
输出：3
解释：
我们选中 [0,2], [8,10], [1,9] 这三个片段。
然后，按下面的方案重制比赛片段：
将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
```

```java
示例 2：

输入：clips = [[0,1],[1,2]], T = 5
输出：-1
解释：
我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
```

```java
示例 3：

输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
输出：3
解释： 
我们选取片段 [0,4], [4,7] 和 [6,9] 。
```

```java
示例 4：

输入：clips = [[0,4],[2,8]], T = 5
输出：2
解释：
注意，你可能录制超过比赛结束时间的视频。
```


提示：

1 <= clips.length <= 100
0 <= clips[i][0] <= clips[i][1] <= 100
0 <= T <= 100


链接：https://leetcode-cn.com/problems/video-stitching

## 解题记录

+ 通过list存储视频出现的起始位置和索引的关系，方便之后查找
+ 因为视频一定是从0开始的，那么写一个while循环，第一次找到以0其实的最大值max
+ 然后在1到max的之间为起始的，找到这部分中另一端的最大值，如果没有找到更大的还没到T那么说明不可能达到，返回-1
+ 如果max大于等于T说明可以，返回count

```java
/**
 * @author: ffzs
 * @Date: 2020/10/24 上午10:44
 */
public class Solution {

    public static int videoStitching(int[][] clips, int T) {
        List<List<Integer>> tmp = new ArrayList<>(T+1);
        for (int i = 0; i <= T; i++) tmp.add(new ArrayList<>());

        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] < T) tmp.get(clips[i][0]).add(i);
        }

        int cur = 0, pre = 0, count=0, max;
        while (cur < T) {
            max = pre;
            for (int i = pre; i <= cur; i++) {
                List<Integer> lst = tmp.get(i);
                for (Integer integer : lst) {
                    max = Math.max(clips[integer][1], max);
                }
            }
            if (max == pre) return -1;
            pre = cur+1;
            cur = max;
            count++;
            if (max >= T) return count;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] clips = {{0,4},{2,8}};
        System.out.println(Solution.videoStitching(clips, 10));
    }
}
```

![image-20201024112718978](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201024112718978.png)

+ 可能是用了list做一部分数据的缓存归纳，但是对int数据做了包装，会有一定的消耗
+ 由于clips长度不大，也可以每次都循环一遍clips，找到适合的起始点
+ 由于减少了list的使用，以及装饰过程，时间内存都有优化

```java
/**
 * @author: ffzs
 * @Date: 2020/10/24 上午11:29
 */
public class Solution2 {
    public int videoStitching(int[][] clips, int T) {

        int cur = 0, max = 0, count = 0;
        while (cur < T) {
            for (int[] clip : clips) {
                if (clip[0] <= cur) {
                    max = Math.max(clip[1], max);
                }
            }
            count++;
            if (max >= T) return count;
            if (max == cur) return -1;
            cur = max;
        }
        return -1;
    }
}
```

![image-20201024113554416](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201024113554416.png)