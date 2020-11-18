package canCompleteCircuit;

/**
 * @author: ffzs
 * @Date: 2020/11/18 上午10:35
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] remain = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            remain[i] = gas[i] - cost[i];
            sum += remain[i];
        }

        if (sum < 0) return -1;
        for (int i = 0; i < n; i++) {
            if (remain[i]>=0 && check(remain, i)) return i;
        }
        return -1;
    }

    private boolean check(int[] remain, int start){
        int sum = 0;
        for (int i = start; i < remain.length; i++) {
            sum += remain[i];
            if (sum<0) return false;
        }
        for (int i = 0; i < start; i++) {
            sum += remain[i];
            if (sum<0) return false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
