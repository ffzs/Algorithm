## [621. 任务调度器](https://leetcode-cn.com/problems/task-scheduler/)

## 题目

给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。

然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 最短时间 。

```java
示例 1：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
示例 3：

输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
```


提示：

1 <= task.length <= 104
tasks[i] 是大写英文字母
n 的取值范围为 [0, 100]



链接：https://leetcode-cn.com/problems/task-scheduler



## 解题记录

+ 优先统计字符出现次数
+ 将次数排序优先处理出现次数多的然后分别每次遍历获取计算
+ 运行过程中调整排序保证始终最大值在前



```java
/**
 * @author: ffzs
 * @Date: 2020/12/5 下午5:05
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] tmp = new int[26];
        int count = 0;
        for (char c : tasks) {
            if (tmp[c - 'A'] == 0) count++;
            tmp[c - 'A']++;
        }
        Arrays.sort(tmp);
        int[] counter = new int[count];
        for (int i = 0; i < counter.length; i++) {
            counter[counter.length-i-1] = tmp[25-i];
        }
        int i = 0, res = 0, j = 0;
        while (i < tasks.length) {
            int k = counter.length-1;
            j = 0;
            while (j <= n && k >=0) {
                if (counter[k] > 0) {
                    counter[k]--;
                    j++;
                    i++;
                }
                k--;
            }
            if (k >= 0 && counter[k]>counter[k+1]) Arrays.sort(counter);
            res += n-j+1;
        }
        return res+tasks.length-n+j-1;
    }

}

class Test{
    public static void main(String[] args) {
//        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        char[] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(tasks, 2));
    }
}
```

![image-20201205181734956](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201205181734956.png)

+ 出现最多的次数为max，最大的情况是$(n+1)*max$， 最小的情况为`tasks.length`
+ 出现最多的情况是有n+1个字符出现了max次，也就是说如果只有一个字符出现了max次，那么情况为$(n+1)*(max-1)+1$
+ 需要统计出出现max的字符数

```java
/**
 * @author: ffzs
 * @Date: 2020/12/5 下午6:21
 */
public class Solution2 {

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char c : tasks) {
            counter[c-'A']++;
        }
        int max = 0;
        for (int i : counter) {
            max = Math.max(max, i);
        }
        int maxNum = 0;
        for (int i : counter) {
            if (i == max) maxNum++;
        }
        return Math.max((n+1)*(max-1)+maxNum, tasks.length);
    }
}
```

![image-20201205183057598](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201205183057598.png)