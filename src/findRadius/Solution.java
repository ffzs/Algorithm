package findRadius;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/20 上午7:23
 */
public class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int m = houses.length, n = heaters.length;

        if (heaters[0] - houses[0] > res) res = heaters[0] - houses[0];
        int i = 0, j = 1;
        while (i < m && houses[i] <= heaters[0]) i++;
        while (i < m && j < n) {
            while (i < m && houses[i] <= heaters[j]) {
                res = Math.max(res, Math.min(houses[i] - heaters[j-1], heaters[j] - houses[i]));
                i++;
            }
            j++;
        }

        return Math.max(res, houses[m-1] - heaters[n-1]);
    }

}


class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};

        System.out.println(s.findRadius(houses, heaters));
    }
}
