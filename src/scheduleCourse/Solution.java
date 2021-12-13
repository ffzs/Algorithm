package scheduleCourse;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/12/14 上午7:34
 * 两门课优先学习关闭较早的课为最优
 */
public class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer>  pq = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        for (int[] course : courses) {
            int t = course[0], d = course[1];
            if (total + t <= d) {
                total += t;
                pq.offer(t);
            }
            else if (!pq.isEmpty() && pq.peek() > t) {
                total -= pq.poll() - t;
                pq.offer(t);
            }
        }
        return pq.size();
    }

}
