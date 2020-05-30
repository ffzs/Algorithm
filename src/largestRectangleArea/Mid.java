package largestRectangleArea;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/30
 */
public class Mid {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, maxArea = 0;
        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            while (left>=0 && heights[left]>=heights[i]) left--;
            while (right<len && heights[right]>=heights[i]) right++;
            maxArea = Math.max(maxArea, (right-left-1)*heights[i]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
