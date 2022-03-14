package findRestaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/3/14 上午8:13
 */
public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        String[] tmp = new String[Math.min(n1,n2)];
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i <= n1 + n2 - 2; i++) {
            for (int j = 0; j <= i && j < n1; j++) {
                int k = i - j;
                if (k >= n2) continue;
                if (list1[j].equals(list2[k])) {
                    tmp[idx++] = list1[j];
                    flag = true;
                }
            }
            if (flag) break;
        }
        String[] res = new String[idx];
        System.arraycopy(tmp, 0, res, 0, res.length);
        return res;
    }


    public String[] findRestaurant2(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        if (n2 > n1) return findRestaurant(list2, list1);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new ArrayList<>();
        int min = n1 + n2;
        for (int i = 0; i < list2.length && i < min; i++) {
            if (map.containsKey(list2[i])) {
                int idx = map.get(list2[i]) + i;
                if (idx == min) res.add(list2[i]);
                else if (idx < min) {
                    min = idx;
                    res.clear();
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[]{});
    }

}

class Test {
    public static void main(String[] args) {
        String[] list1 = {"vacag","KFC"};
        String[] list2 = {"fvo","xrljq","jrl","KFC"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findRestaurant(list1, list2)));
    }
}
