package largestRectangleArea;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/30
 *
 * 转化为求子数组中最小值*数组长度的最大值的问题
 *
 */
public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, maxArea = -1;
        for (int i = 0; i < len; i++) {
            int min = heights[i];
            for (int j = i; j < len; j++) {
                min = Math.min(min,heights[j]);
                maxArea = Math.max(maxArea, min*(j-i+1));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
