package shortestPalindrome;

/**
 * @author: ffzs
 * @Date: 2020/8/29 上午8:04
 */
public class Solution {
    public static String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();
        if(seq.length == 0) return s;
        int left, right;
        StringBuilder res = new StringBuilder();
        for (int i = (seq.length-1)/2; i >= 0; i--) {
            for (int k = 0; k < 2 ; k++) {
                if ((seq.length & 1) == 1){
                    left = i-k;
                    right = i;
                }else{
                    left = i;
                    right = i+1-k;
                }
                while (left>=0 && seq[left] == seq[right]) {
                    if(left == 0){
                        for(int j = seq.length-1; j>right; --j) res.append(seq[j]);
                        return res.append(seq).toString();
                    }
                    left--; right++;
                }
            }
        }
        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = "aacecaaa";

        System.out.println(Solution.shortestPalindrome(s));
    }
}
