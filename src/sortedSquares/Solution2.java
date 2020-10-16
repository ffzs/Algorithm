package sortedSquares;

/**
 * @author: ffzs
 * @Date: 2020/10/16 上午7:48
 */
public class Solution2 {

    public int[] sortedSquares(int[] A) {
        int left = 0, right = A.length-1;
        int[] res = new int[A.length];
        int index = A.length-1;
        while (left <= right){
            if (-A[left] > A[right]) {
                res[index--] = A[left]*A[left];
                left++;
            }
            else {
                res[index--] = A[right]*A[right];
                right--;
            }
        }

        return res;
    }
}
