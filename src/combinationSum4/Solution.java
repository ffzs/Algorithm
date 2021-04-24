package combinationSum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/4/24 上午10:04
 */
public class Solution {

    int[] nums;
    int target;
    int[] counter;
//    List<Integer> list = new ArrayList<>();
    int res = 0;

    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.counter = new int[nums.length];
        Arrays.sort(this.nums);

        dfs(0, 0);
        return res;
    }

    private void dfs(int sum, int i) {
        if (sum >= target) {
            if (sum == target) deal();
            return;
        }
        for (int j = i; j < nums.length; j++) {
            int num = nums[j];
            if (sum + num <= target) {
                sum += num;
//                list.add(num);
                counter[j]++;
                dfs(sum, j);
                counter[j]--;
//                list.remove(list.size() - 1);
                sum -= num;
            }
        }
    }

    private void deal() {
        int sum = 0, cnt = 0;
        for (int i : counter) {
            if (i != 0) {
                cnt ++;
                sum += i;
            }
        }
        int ret = 1;
//        System.out.println(list);
        for (int i = 0; i < counter.length && cnt > 1; i++) {
            if (counter[i] != 0 && sum > 1) {
                ret *= combinations(sum, counter[i]);
//                System.out.println("a,b : " + sum + ", " + counter[i] + "   res:" + ret);
                sum -= counter[i];
                cnt--;
            }
        }

        res += ret;
    }

    private int combinations(int a, int b) {
        // 这里可以判断 a， b 重合部分(a-b)>b的情况， 去掉重复部分
        if (b > a-b) b = a-b;
        long up = 1, down = 1;
        for (int i = 0; i < b; i++) {
            up *= (a - i);
            down *= (b - i);
        }
        return (int) (up / down);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,50};
        int[] nums = {5,1,8};
        System.out.println(solution.combinationSum4(nums, 24));
    }
}
