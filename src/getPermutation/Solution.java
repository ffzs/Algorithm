package getPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/5 上午8:39
 */
public class Solution {

    public String getPermutation(int n, int k) {
        if (n==1) return "1";
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tmp.add(i);
        }
        int total = factorial(n - 1);
        int index, remain=k-1;
        StringBuilder res = new StringBuilder();
        for (int i = n - 1; i > 1; --i) {
            index = remain/total;
            remain = remain%total;
            total = total/i;
            res.append(tmp.remove(index));
        }
        res.append(tmp.remove(remain));
        res.append(tmp.get(0));
        return res.toString();
    }

    private int factorial(int n) {
        if (n < 1) return -1;
        else if (n == 1) return 1;
        else return factorial(n - 1) * n;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3,3));
    }
}


