package simplifyPath;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: ffzs
 * @Date: 2022/1/6 上午8:17
 */
public class Solution {

    public String simplifyPath(String path) {
        String[] items = path.split("/");
        Deque<String> sk = new LinkedList<>();
        for (String it : items) {
            switch (it) {
                case ".":
                case "":
                    continue;
                case "..":
                    if (!sk.isEmpty()) sk.removeFirst();
                    break;
                default:
                    sk.addFirst(it);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!sk.isEmpty()) {
            sb.append("/").append(sk.removeLast());
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

}
