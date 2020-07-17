package minimumTotal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/14
 */
public class Solution2 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n-2; i >= 0; --i) {
            for (int i1 = 0; i1 < triangle.get(i).size(); ++i1) {
                triangle.get(i).set(i1, Math.min(triangle.get(i+1).get(i1), triangle.get(i+1).get(i1+1)) + triangle.get(i).get(i1));
            }
        }
        return triangle.get(0).get(0);
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
