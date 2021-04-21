package numDecodings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: ffzs
 * @Date: 2021/4/21 上午9:12
 */
public class Solution {
    HashMap<String, Character> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    int n;
    StringBuilder sb = new StringBuilder();
    String s;
    public int numDecodings(String s) {
        n = s.length();
        this.s= s;
        for (int i = 0; i < 26; i++) {
            String v = String.valueOf(i+1);
            map.put(v, (char)('A' + i));
        }
        dfs(0,1);
        dfs(0,2);
        System.out.println(set);
        System.out.println(set.size());
        return set.size();
    }

    private void dfs (int start, int end) {
        if (end > n) {
            String code = new String(sb);
            if (!code.equals("")) set.add(code);
            return;
        }

        String cur = s.substring(start, end);
//        System.out.println(cur);

        if(!map.containsKey(cur)) return;

        sb.append(map.get(cur));
        dfs(end, end+1);
        if (end+2 <= n) dfs(end, end+2);
        sb.deleteCharAt(sb.length()-1);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0";
        System.out.println(solution.numDecodings(s));
    }
}
