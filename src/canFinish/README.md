## [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)

## 题目

你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

```java
 示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
```



```java
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
```



```java
提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
```


链接：https://leetcode-cn.com/problems/course-schedule

## 解题记录

+ 之前做过一样的 [Leetcode:NO.210课程表2 拓扑排序与入度](https://blog.csdn.net/tonydz0523/article/details/106174312)

```java
/**
 * @author: ffzs
 * @Date: 2020/8/4 上午7:19
 */
public class Solution {

    ArrayList<Integer>[] table;
    int[] step;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        table = new ArrayList[numCourses];
        step = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) table[i] = new ArrayList<>();

        for (int[] p : prerequisites) {
            table[p[0]].add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i)) return false;
        }

        return true;
    }

    private boolean isCycle(int i) {
        if (step[i] == 1) return true;  // 如果搜索中出现完成那么说明出现了环
        if (step[i] == -1) return false;

        step[i] = 1;  // 标定搜索中

        for (Integer it : table[i]) {
            if (isCycle(it)) return true;
        }

        step[i] = -1;  // 标定搜索完成

        return false;
    }
}

```

![image-20200804085457325](README.assets/image-20200804085457325.png)