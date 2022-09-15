package flipLights;

/**
 * @author: ffzs
 * @Date: 2022/9/15 上午8:35
 *
 * kkkkkk 0,2
 * gggggg 1,3
 * kgkgkg 1,3
 * gkgkgk 1,3
 * gkkgkk
 * kggkgg
 * ggkkkg
 * kkgggk
 */
public class Solution {

    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        else if (n == 2) {
            if (presses == 1) return 3;
            else return 4;
        }
        else {
            if (presses == 1) return 4;
            else if (presses == 2) return 7;
            else return 8;
        }
    }

}
