package arrayNesting;

/**
 * @author: ffzs
 * @Date: 2022/7/17 上午8:26
 */
public class Solution {

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        int res = 0, cnt, next;
        for (int i = 0; i < n; i+=1) {
            if (visited[i]) continue;
            cnt = 0;
            next = i;
            while (!visited[next]) {
                cnt += 1;
                visited[next] = true;
                next = nums[next];
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

}
