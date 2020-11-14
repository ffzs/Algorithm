package relativeSortArray;

/**
 * @author: ffzs
 * @Date: 2020/11/14 上午9:39
 */
public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] counter = new int[1001];
        for (int i : arr1) {
            counter[i]++;
        }
        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < counter[i]; j++) {
                arr1[idx++]=i;
            }
            counter[i] = 0;
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] !=0) {
                for (int i1 = 0; i1 < counter[i]; i1++) {
                    arr1[idx++] = i;
                }
            }
        }
        return arr1;
    }
}
