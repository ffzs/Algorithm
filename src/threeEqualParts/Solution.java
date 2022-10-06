package threeEqualParts;

/**
 * @author: ffzs
 * @Date: 2022/10/6 上午11:27
 */
public class Solution {

    public int[] threeEqualParts(int[] arr) {
        int oneCnt = 0, n = arr.length;
        for (int i : arr) {
            oneCnt += i;
        }
        if (oneCnt == 0) return new int[]{0,n-1};
        if (oneCnt % 3 != 0) return new int[] {-1, -1};

        int preOne = oneCnt/3;
        int idx = n, cnt = 0;
        while (cnt < preOne) {
            if (arr[--idx] == 1) cnt += 1;
        }
        int i = 0;
        while (arr[i] == 0) i += 1;
        for (int k = idx; k < n; k++) {
            if (arr[i++] != arr[k]) return new int[] {-1, -1};
        }
        i -= 1;
        int j = i + 1;
        while (arr[j] == 0) j += 1;
        for (int k = idx; k < n; k++) {
            if (arr[j++] != arr[k]) return new int[] {-1, -1};
        }
        return new int[] {i, j};
    }

}
