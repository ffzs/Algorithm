package uniqueOccurrences;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/10/28 上午10:36
 */
public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counter = new int[2000];
        for (int i : arr) {
            counter[i+1000]++;
        }
        boolean[] unique = new boolean[1001];
        for (int i : counter) {
            if (i!=0) {
                if (!unique[i]) unique[i] = true;
                else return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length==1) return true;
        boolean[] unique = new boolean[1001];
        Arrays.sort(arr);
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i+1 < arr.length && arr[i] == arr[i+1]) counter++;
            else {
                if (!unique[counter]) unique[counter] = true;
                else return false;
                counter = 1;
            }
        }
        return true;
    }
}
