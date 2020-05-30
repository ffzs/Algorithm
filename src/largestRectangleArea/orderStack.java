package largestRectangleArea;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/30
 */
public class orderStack {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length, res = 0;
        int[] left = new int[len], right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            left[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = len-1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            right[i] = stack.isEmpty()? len: stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < len ; i++) {
            res = Math.max(res, (right[i]-left[i]-1)*heights[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }
}
