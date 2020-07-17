package minimumTotal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/14
 */
public class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] tmp = new int[triangle.size()];
        int n = triangle.size();
        List<Integer> last = triangle.get(n - 1);
        for (int i = 0; i < last.size(); ++i) {
            tmp[i] = last.get(i);
        }

        for (int i = n-2; i >= 0; --i) {
            List<Integer> level = triangle.get(i);
            for (int i1 = 0; i1 < level.size(); ++i1) {
                tmp[i1] = Math.min(tmp[i1], tmp[i1+1]) + level.get(i1);
            }
        }
        return tmp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3,4)));
        triangle.add(new ArrayList<>(List.of(6,5,7)));
        triangle.add(new ArrayList<>(List.of(4,1,8,3)));
        System.out.println(minimumTotal(triangle));
    }
}
