package canFinish;

import java.util.ArrayList;

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
