package numRescueBoats;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/26 上午6:49
 */
public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int res = 0;
        while (l <= r){
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        return res;
    }

}
