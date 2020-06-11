package dailyTemperatures;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/11
 */
public class Solution2 {
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        res[len-1] = 0;  // 最后一个一定为0
        for (int i = len-2; i >=0 ; --i) {
            int j = i+1;
            while (true) {
                if (T[j] > T[i]) {
                    res[i] = j-i;
                    break;
                }else if (res[j] == 0) {
                    res[i] = 0;   //  如果0 说明没有比后面没有比T[j]大的，且T[i] >= T[j]. 那么T[i]后面更没有比它大的了
                    break;
                }else{
                    j += res[j];  // 一直通过之前记录找到比T[i]大的
                }
            }
        }
        return res;
    }
}
