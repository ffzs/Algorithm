package minArray;

/**
 * @author: ffzs
 * @Date: 2020/7/22 上午8:04
 */
public class Solution2 {
    public static int minArray(int[] numbers) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int mid = l+r >>> 1;
            if (numbers[mid] < numbers[r]) r = mid;
            else if (numbers[mid] > numbers[r]) l = mid+1;
            else r--;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(minArray(nums));
    }
}
