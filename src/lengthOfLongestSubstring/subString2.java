package lengthOfLongestSubstring;

public class subString2 {
    public static int lengthOfLongestSubstring (String s) {
        int[] tmp = new int[128];
        int max=0, j=0, i=0;
        while(i<s.length()-max){
            int theChar = s.charAt(i);
            if (tmp[theChar] > 0) j = Math.max(tmp[theChar], j);
            max = Math.max(max, i-j+1);
            tmp[theChar] = i+1;
            ++i;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
