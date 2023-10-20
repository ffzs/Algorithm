package categorizeBox;

/**
 * @author: ffzs
 * @Date: 2023/10/20 上午8:40
 */
public class Solution {
    static final int LEN = 10000, VOLUME = (int)1e9, MASS = 100;
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false, isHeavy = false;
        if (length >= LEN || width >= LEN || height >= LEN || (long)length * width * height >= VOLUME) isBulky = true;

        if (mass >= MASS) isHeavy = true;

        String res = "Neither";
        if (isBulky && isHeavy) res = "Both";
        else if (isBulky) res = "Bulky";
        else if (isHeavy) res = "Heavy";

        return res;
    }

}
