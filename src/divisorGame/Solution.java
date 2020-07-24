package divisorGame;

/**
 * @author: ffzs
 * @Date: 2020/7/24 上午7:43
 */

public class Solution {

    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(divisorGame(N));
    }
}
