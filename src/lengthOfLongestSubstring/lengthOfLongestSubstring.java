package lengthOfLongestSubstring;

public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring (String s) {
        char[] seq = s.toCharArray();
        int i1=0, i2=0, max=0, ret=-1;
        while (i1<seq.length){
            i2=i1;
            while(i2<seq.length ){
                ret = checkUnique(i1,i2,seq);
                if (ret==-1){
                    i2++;
                }else{
                    break;
                }
            }
            max = Math.max(i2-i1, max);
            i1=(ret==-1)?i2:ret+1;
        }
        return max;
    }

    static int checkUnique(int i1, int i2, char[] seq){
        for (int i=i1;i<i2;++i){
            if(seq[i]==seq[i2]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        char[] ss = new char[128];
        System.out.println((int)ss[1]);
//        System.out.println(lengthOfLongestSubstring(s));
    }
}
