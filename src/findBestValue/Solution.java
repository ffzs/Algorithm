package findBestValue;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/14
 */
public class Solution {
    public static int findBestValue(int[] arr, int target) {
        int len = arr.length;
        int cut = target / len;
        Arrays.sort(arr);

        int sum = arr[0];

        if (cut <= sum) {
            return target - cut * len > (cut+1) * len -target ? cut + 1: cut;
        }

        for (int i = 1; i < len; i++) {
            if (arr[i]>cut){
                int tmp = (target-sum)/(len-i);
                if (arr[i] > tmp) {
                    return target - (sum + tmp*(len-i)) > (sum + (tmp + 1)*(len-i)) - target ? tmp+1: tmp;
                }
            }
            sum += arr[i];
        }
        return arr[len-1];
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,23,24,34,36};
        int[] arr = {60864,25176,27249,21296,20204};
        System.out.println(findBestValue(arr,  56803));
    }
}
