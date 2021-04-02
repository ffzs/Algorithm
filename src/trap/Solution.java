package trap;

/**
 * @author: ffzs
 * @Date: 2021/4/2 上午8:52
 */
public class Solution {

    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int lm = 0, rm = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (lm > height[l]) res += lm - height[l];
                else lm = height[l];
                l++;
            }
            else {
                if (rm > height[r]) res += rm - height[r];
                else rm = height[r];
                r--;
            }
        }
        return res;
    }

}
