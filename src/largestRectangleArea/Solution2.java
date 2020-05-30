package largestRectangleArea;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/30
 */
public class Solution2 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, res = 0;
        int[] left = new int[len], right = new int[len];

        for (int i = 0; i < len; ++i) {
            left[i] = i;
            int preIdx = i - 1;
            while (preIdx >= 0 && heights[preIdx] >= heights[i] ) {
                left[i] = left[preIdx];
                preIdx = left[i] - 1;
            }
        }

        for (int i = len - 1; i >= 0; --i) {
            right[i] = i;
            int preIdx = i + 1;
            while (preIdx < len && heights[preIdx] >= heights[i]) {
                right[i] = right[preIdx];
                preIdx = right[i] + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            res = Math.max(res, (right[i]-left[i]+1)*heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
