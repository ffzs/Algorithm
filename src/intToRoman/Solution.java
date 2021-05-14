package intToRoman;

import java.net.Socket;

/**
 * @author: ffzs
 * @Date: 2021/5/14 上午7:49
 */
public class Solution {

    public String intToRoman(int num) {
        int[] v = {1000, 500, 100, 50, 10, 5, 1};
        int[] gap = {100, 100, 10, 10, 1, 1, 0};
        char[] c = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        char[] gc = {'C', 'C', 'X', 'X', 'I', 'I', 'I'};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num != 0) {
            if (num / v[i] != 0) {
                sb.append(c[i]);
                num -= v[i];
            }
            else if (num % v[i] + gap[i] >= v[i]){
                sb.append(gc[i]);
                num += gap[i];
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(1994));
    }
}
