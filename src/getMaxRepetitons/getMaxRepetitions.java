package getMaxRepetitons;

public class getMaxRepetitions {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] seq1 = s1.toCharArray();
        char[] seq2 = s2.toCharArray();
        if (n1==0) return 0;
        // 最慢的情况是每一个s1匹配到s2上一个字符，因此s2长度加一就能匹配到周期
        int minTimes = Math.min(seq2.length+1, n1);
        int[] counter=new int[minTimes];
        int[] index=new int[2];
        for (int i=0; i<minTimes;++i){
            if (i==1) index[1]=index[0];
            if (i!=0) counter[i] = counter[i-1];
            for (int j=0; j<seq1.length; ++j) {
                if (seq1[j] == seq2[index[0]]) index[0]++;
                if (index[0] == seq2.length) {
                    counter[i]++;
                    index[0] = 0;
                }
            }
            if (i!=0 && index[1]==index[0]){
                return ((counter[i]-counter[0]) * ((n1-1)/i) + counter[(n1-1)%i]) /n2;
            }
        }
        final int precount = n1 / minTimes * counter[minTimes - 1];
        return n1%minTimes==0? precount /n2:(precount +counter[n1/minTimes-1])/n2;
    }

    public static int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        return include(concat(s1,n1), concat(s2, n2));
    }

    static int include(String seq1, String seq2){
        int count=0, j=0;
        for (int i=0; i<seq1.length(); ++i){
            if (seq1.charAt(i)==seq2.charAt(j%seq2.length())) {
                if(j%seq2.length()==seq2.length()-1) count++;
                j++;
            }
        }
        return count;
    }

    static String concat(String s, int n){
        return String.valueOf(s).repeat(Math.max(0, n));
    }


    public static void main(String[] args) {
        String s1 = "baba";
        String s2 = "baab";
        int n1 = 3;
        int n2 = 1;
        System.out.println(getMaxRepetitions(s1, n1, s2, n2));
//            System.out.println(i+"->"+include(concat(s1,i), concat(s2, 1)));

    }
}
