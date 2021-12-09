package shortestCompletingWord;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/10 上午7:26
 */
public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lCnt = count(licensePlate);
        int total = 0;
        for (int i : lCnt) total += i;
//        System.out.println(Arrays.toString(lCnt));
        String res = words[0];
        int minLen = Integer.MAX_VALUE;
        boolean flag = true;
        for (String word : words) {
            if (word.length() >= total) {
                int[] wCnt = count(word);
                for (int i = 0; i < 26; i++) {
                    if (lCnt[i] != 0 && wCnt[i] < lCnt[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag && word.length() < minLen) {
                    res = word;
                    minLen = word.length();
                }
                flag = true;
            }
        }
        return res;
    }

    private int[] count (String word) {
        int[] cnt = new int[26];
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') cnt[c-'a'] ++;
            else if (c >= 'A' && c <= 'Z') cnt[c - 'A'] ++;
        }
        return cnt;
    }

}

class Test {
    public static void main(String[] args) {
        System.out.println('A' - 'a');
    }
}
