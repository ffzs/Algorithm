package countSmaller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/11
 */
public class Solution3 {
    static int[] ns, tmp, is, ctr;
    public static List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();
        ctr = new int[len];
        tmp = new int[len];
        is = new int[len];
        for (int i = 0; i < len; i++) is[i] = i;
        ns = nums;
        split(0, len-1);
        List<Integer> res = new ArrayList<>(len);
        for (int i : ctr) res.add(i);
        return res;
    }

    private static void split (int l, int r) {
        if (l == r) return;
        int mid = l + r >> 1;
        split(l, mid);
        split(mid+1, r);
        if (ns[is[mid]] > ns[is[mid+1]]) merge(l ,mid ,r);
    }

    private static void merge (int l, int mid , int r) {
        if (r + 1 - l >= 0) System.arraycopy(is, l, tmp, l, r + 1 - l);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; ++k) {
            if (j > r) {
                ctr[tmp[i]] += r - mid;
                is[k] = tmp[i++];
            }
            else if (i > mid)
                is[k] = tmp[j++];
            else if (ns[tmp[i]] <= ns[tmp[j]]) {
                ctr[tmp[i]] += k - i;
                is[k] = tmp[i++];
            }
            else
                is[k] = tmp[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(countSmaller(nums));
    }

}
