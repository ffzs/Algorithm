package prevPermOpt1;

/**
 * @author: ffzs
 * @Date: 2023/4/3 上午8:23
 */
public class Solution {

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int j = n-1;
                for (; j > i; j--) {
                    if (arr[j] < arr[i] && arr[j] != arr[j-1]) {
                        break;
                    }
                }
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                break;
            }
        }
        return arr;
    }

}
