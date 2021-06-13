package guessNumber;

/**
 * @author: ffzs
 * @Date: 2021/6/14 上午7:06
 */

class GuessGame {
    public int guess(int num){
        return 1;
    }
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = (l + r) >>> 1;

            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) l = mid + 1;
            else r = mid;
        }

        return l;
    }

}
