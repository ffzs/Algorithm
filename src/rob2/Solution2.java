package rob2;

/**
 * @author: ffzs
 * @Date: 2021/4/15 上午10:00
 */
public class Solution2 {

    static class Box {
        private int num;
        private boolean first = false;

        public Box(int num) {
            this.num = num;
        }

        public void markFirst() {
            this.first = true;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public Box add(Box b) {
            this.num += b.getNum();
            this.first = this.first || b.isFirst();
            return this;
        }

        public boolean compare(Box b) {
            return this.num > b.getNum();
        }
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        Box[] bs = new Box[n];
        for (int i = 0; i < nums.length; i++) {
            bs[i] = new Box(nums[i]);
            if (i == 0) bs[i].markFirst();
        }

        Box[] dp = new Box[n + 1];
        dp[0] = new Box(0);
        dp[1] = bs[0];
        for (int i = 2; i <= n; ++i) {
            Box cur = bs[i - 1].add(dp[i - 2]);
            if (i == n) dp[i] = cur.compare(dp[i - 1]) && !cur.isFirst() ? cur : dp[i - 1];
            else if (dp[i - 1].getNum() == cur.getNum()) dp[i] = dp[i - 1].isFirst() ? cur : dp[i - 1];
            else dp[i] = dp[i - 1].getNum() >= cur.getNum() ? dp[i - 1] : cur;
        }
        for (Box box : dp) {
            System.out.println("num: " + box.getNum() + "; isFirst: " + box.isFirst());
        }
        return dp[n].getNum();
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3};
        Solution2 s = new Solution2();
        System.out.println(s.rob(nums));
    }
}
