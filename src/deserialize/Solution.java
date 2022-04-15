package deserialize;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/4/15 上午8:04
 */
class NestedInteger { // Constructor initializes an empty nested list.
        public NestedInteger() {};

        public NestedInteger(int value) {};

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        };

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        };

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        };

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {};

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {return new ArrayList<>(); };
}


public class Solution {

    public NestedInteger deserialize(String s) {
        char[] cs = s.toCharArray();
        if (cs[0] != '[') return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> deque = new LinkedList<>();
        int num = 0;
        int label = 1;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == '-') label = -1;
            else if (c >= '0' && c<='9') num = num * 10 + c - '0';
            else if (c == '[') deque.push(new NestedInteger());
            else if (c == ',' || c == ']') {
                if (cs[i-1] >= '0' && cs[i-1] <= '9') {
                    deque.peek().add(new NestedInteger(label * num));
                }
                label = 1;
                num = 0;
                if (c == ']' && deque.size() > 1) {
                    NestedInteger cur = deque.pop();
                    deque.peek().add(cur);
                }
            }
        }
        return deque.pop();
    }

}
