package smallestSufficientTeam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/4/8 下午1:16
 */
public class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();

        int n = req_skills.length;
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, people.size());
        dp[0] = 0;
        int[] prePerson = new int[1 << n];
        int[] preSkills = new int[1 << n];
        for (int i = 0; i < people.size(); i++) {
            List<String> lst = people.get(i);
            int mask = 0;
            for (String s : lst) {
                mask |= (1 << map.get(s));
            }

            for (int pre = 0; pre < (1 << n); pre++) {
                int c = mask | pre;
                if (dp[c] > dp[pre] + 1){
                    dp[c] = dp[pre] + 1;
                    prePerson[c] = i;
                    preSkills[c] = pre;
                }
            }
        }

        int[] res = new int[people.size()];
        int i = 0, p = (1 << n) - 1;
        while (p > 0) {
            res[i++] = prePerson[p];
            p = preSkills[p];
        }
        return Arrays.copyOf(res, i);
    }

}
