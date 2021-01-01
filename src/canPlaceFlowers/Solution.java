package canPlaceFlowers;

/**
 * @author: ffzs
 * @Date: 2021/1/1 上午8:18
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) i += 2;
            else {
                if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) {
                    n--;
                    i += 2;
                }
                else i += 3;
            }
            if (n <= 0) return true;
        }
        return false;
    }
}
