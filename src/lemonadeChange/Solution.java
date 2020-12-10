package lemonadeChange;

/**
 * @author: ffzs
 * @Date: 2020/12/10 上午8:09
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] counter = new int[2];
        for (int b : bills) {
            if (b == 5) counter[0]++;
            else if (b == 10){
                if (counter[0] <= 0) return false;
                else {
                    counter[0]--;
                    counter[1]++;
                }
            }
            else {
                if (counter[1]>=1 && counter[0] >= 1) {
                    counter[1]--;
                    counter[0]--;
                }
                else if (counter[0] >=3) counter[0] -= 3;
                else return false;
            }
        }
        return true;
    }
}
