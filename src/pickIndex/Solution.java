package pickIndex;

/**
 * @author: ffzs
 * @Date: 2021/8/30 上午6:49
 */
public class Solution {
    int[] w;
    int total;
    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            this.w[i] += this.w[i-1];
        }
        total = this.w[w.length-1];
    }

    public int pickIndex() {
        int r = (int)(Math.random()*total) + 1;
        return binarySearch(r);
    }

    private int binarySearch(int i) {
        int l =0, r = w.length-1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (w[mid] < i) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
