package findOrder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/17
 */
public class findOrder {
    public int[] findOrder (int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return prerequisites[0];
        // 创建入度表
        int[] indegree = new int[numCourses], res = new int[numCourses];
        for (int[] pr: prerequisites) {
            indegree[pr[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            res[count++] = index;
            for (int[] pr: prerequisites) {
                if (pr[1] == index) {
                    if (indegree[pr[0]] == 1) queue.offer(pr[0]);
                    else indegree[pr[0]] --;
                }
            }
        }
        return count == numCourses? res: new int[0];
    }
}
