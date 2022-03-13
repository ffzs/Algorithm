package validUtf8;

/**
 * @author: ffzs
 * @Date: 2022/3/13 上午8:50
 */
public class Solution {

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int ret = getType(data[i]);
            if (ret == 1) continue;
            else if (ret < 1) return false;
            else if (i + ret - 1 >= data.length) return false;
            else {
                for (int j = 1; j < ret; j++) {
                    if (getType(data[j + i]) != 0) return false;
                }
                i += ret-1;
            }
        }
        return true;
    }


    private int getType (int num) {
        int f = num >> 7;
        if (f == 0) return 1;
        else {
            if (((num >> 6) & 1) == 0) return 0;
            int cnt = 2;
            for (int i = 5; i >= 1; --i) {
                if (((num >> i) & 1) == 1) ++cnt;
                else break;
            }
            return cnt > 4 ? -1: cnt;
        }
    }

}
