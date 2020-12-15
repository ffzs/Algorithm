package monotoneIncreasingDigits;

/**
 * @author: ffzs
 * @Date: 2020/12/15 上午7:59
 */

public class Solution {

    public int monotoneIncreasingDigits(int N) {
        boolean isIncrease = true;

        String str = String.valueOf(N);
        int[] tmp = new int[str.length()];
        int idx = -1;
        for (int i = 0; i < str.length(); i++) {
            tmp[i] = str.charAt(i) - '0';
            if (isIncrease && i>0 && tmp[i-1]>tmp[i]) {
                isIncrease = false;
                idx = i-1;
            }
        }
        if (isIncrease) return N;

        while (idx-1>=0 && tmp[idx-1] == tmp[idx]) idx--;
        tmp[idx] = tmp[idx]-1;
        for (int i = idx+1; i < tmp.length; i++) {
            tmp[i] = 9;
        }

        int res = 0;
        for (int i : tmp) {
            res = res*10 + i;
        }

        return res;
    }

}

class Test{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 989998;
        System.out.println(solution.monotoneIncreasingDigits(N));
    }
}
