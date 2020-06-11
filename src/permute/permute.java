package permute;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {
    static List<List<Integer>> result = new ArrayList<>();
    static int[] num;
    static int len;
    public static List<List<Integer>> permute(int[] nums) {
        num = nums;
        len = nums.length;
        boolean[] step = new boolean[len];
        backtrack(new ArrayList<Integer>(), step);
        return result;
    }

    private static void backtrack(List<Integer> tmp, boolean[] step) {
        if (tmp.size() == len) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0; i<len; ++i){
            if (!step[i]) {
                tmp.add(num[i]);
                step[i]=true;
                backtrack(tmp,step);
                tmp.remove(tmp.size()-1);
                step[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
