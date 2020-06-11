package dailyTemperatures;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/11
 */
public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i+1; j < T.length; j++) {
                if(T[j] > T[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }
}
